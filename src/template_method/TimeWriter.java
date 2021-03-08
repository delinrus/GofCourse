package template_method;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeWriter extends FileWriter {

    @Override
    public String getData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return "Current time: " + LocalTime.now().format(dtf);
    }
}
