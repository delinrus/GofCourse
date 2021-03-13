package template_method;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static template_method.Main.printFileToConsole;




public class FileWriterTest {

    private File file;

    @Before
    public void setUp() throws Exception {
        file = File.createTempFile("temp",".tmp");
    }

    private void testHelper(String string) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String collect = br.lines().collect(Collectors.joining());
        br.close();
        assertEquals(string, collect);
    }

    @Test
    public void dateWriter() throws IOException {
        FileWriter dateWriter = new DateWriter();
        dateWriter.write(file);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        testHelper("Current date: " + LocalDate.now().format(dtf));
    }

    @Test
    public void timeWriter() throws IOException {
        FileWriter timeWriter = new TimeWriter();
        timeWriter.write(file);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        testHelper("Current time: " + LocalTime.now().format(dtf));
    }
}