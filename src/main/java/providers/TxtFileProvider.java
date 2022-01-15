package providers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


public class TxtFileProvider {
    public String[] getSentences(String path) throws IOException {
        return Files.lines(Path.of(path))
                .collect(Collectors.joining())
                .replaceAll("[”“\"]", "")
                .replaceAll(",", " ")
                .replaceAll(" +", " ")
                .replaceAll("\\.{2,}", ".")
                .split("[.?!]");
    }
}