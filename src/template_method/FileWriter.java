package template_method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileWriter {

    public void write(File file) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(getData().getBytes());
        }
    }

    public abstract String getData();
}
