import Exporters.CSVExporter;
import org.junit.Assert;
import org.junit.Test;
import providers.TxtFileProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVExporterTest {
    private static final int FILE_EQUALS_FLAG = -1;
    TxtFileProvider txtProvider = new TxtFileProvider();
    CSVExporter csvExporter = new CSVExporter();
    String pathOfTestInput = "src/main/resources/TestInputs/testInput.txt";
    String pathOfTestInputWithChallenge = "src/main/resources/TestInputs/testInputWithChallenges.txt";
    String pathOfTestOutput = "src/main/resources/TestOutputs/testOutput.csv";
    String pathOfCorrectOutput = "src/main/resources/TestCorrectOutputs/correctOutput.csv";

    @Test
    public void exporterGivesCorrectOutputWithClassicInput() throws IOException {
        String[] sentences = txtProvider.getSentences(pathOfTestInput);
        csvExporter.createFile(sentences, pathOfTestOutput);

        Assert.assertEquals(Files.mismatch(Path.of(pathOfTestOutput), Path.of(pathOfCorrectOutput)), FILE_EQUALS_FLAG);
    }

    @Test
    public void exporterGivesCorrectOutputWithChallengingInput() throws IOException {
        String[] sentences = txtProvider.getSentences(pathOfTestInputWithChallenge);
        csvExporter.createFile(sentences, pathOfTestOutput);

        Assert.assertEquals(Files.mismatch(Path.of(pathOfTestOutput), Path.of(pathOfCorrectOutput)), FILE_EQUALS_FLAG);
    }
}
