package template_method;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateWriter extends FileWriter {

    @Override
    public String getData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Current date: " + LocalDate.now().format(dtf);
    }
}
