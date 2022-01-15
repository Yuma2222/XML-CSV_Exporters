package Exporters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public interface Exporter {

    default void createFile(String[] text, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.append(parseStrToStandard(text));
        writer.close();
    }

    String parseStrToStandard(String[] text);
}
