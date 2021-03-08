package template_method;

import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("temp",".tmp");

        FileWriter dateWriter = new DateWriter();
        dateWriter.write(file);
        printFileToConsole(file);

        FileWriter timeWriter = new TimeWriter();
        timeWriter.write(file);
        printFileToConsole(file);
    }

    public static void printFileToConsole(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String collect = br.lines().collect(Collectors.joining());
        br.close();
        System.out.println(collect);
    }
}
