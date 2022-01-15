import Exporters.XMLExporter;
import org.junit.Assert;
import org.junit.Test;
import providers.TxtFileProvider;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class XMLExporterTest {
    private static final int FILE_EQUALS_FLAG = -1;
    TxtFileProvider txtProvider = new TxtFileProvider();
    XMLExporter xmlExporter = new XMLExporter();
    String pathOfTestInput = "src/main/resources/TestInputs/testInput.txt";
    String pathOfTestInputWithChallenge = "src/main/resources/TestInputs/testInputWithChallenges.txt";
    String pathOfTestOutput = "src/main/resources/TestOutputs/testOutput.xml";
    String pathOfCorrectOutput = "src/main/resources/TestCorrectOutputs/correctOutput.xml";

    @Test
    public void exporterGivesCorrectOutputWithClassicInput() throws IOException {
        String[] sentences = txtProvider.getSentences(pathOfTestInput);
        xmlExporter.createFile(sentences, pathOfTestOutput);

        Assert.assertEquals(Files.mismatch(Path.of(pathOfTestOutput), Path.of(pathOfCorrectOutput)), FILE_EQUALS_FLAG);
    }

    @Test
    public void exporterGivesCorrectOutputWithChallengingInput() throws IOException {
        String[] sentences = txtProvider.getSentences(pathOfTestInputWithChallenge);
        xmlExporter.createFile(sentences, pathOfTestOutput);

        Assert.assertEquals(Files.mismatch(Path.of(pathOfTestOutput), Path.of(pathOfCorrectOutput)), FILE_EQUALS_FLAG);
    }
}
