import Exporters.CSVExporter;
import Exporters.XMLExporter;
import providers.TxtFileProvider;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TxtFileProvider txtProvider = new TxtFileProvider();
        CSVExporter csvExporter = new CSVExporter();
        XMLExporter xmlExporter = new XMLExporter();

        System.out.println("Enter full path to file you want to parse: ");
        String pathOfTestInput = new Scanner(System.in).nextLine();
        System.out.println("csv or xml? Can be both.");
        String ext = new Scanner(System.in).nextLine();

        String[] sentences = txtProvider.getSentences(pathOfTestInput);

        switch (ext.toLowerCase(Locale.ROOT)) {
            case "csv" -> csvExporter.createFile(sentences, "testOutput.csv");
            case "xml" -> xmlExporter.createFile(sentences, "testOutput.xml");
            case "both" -> {
                csvExporter.createFile(sentences, "testOutput.csv");
                xmlExporter.createFile(sentences, "testOutput.xml");
            }
        }
    }
}