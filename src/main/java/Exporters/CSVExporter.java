package Exporters;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class CSVExporter implements Exporter {
    private final AtomicInteger wordsInRecord = new AtomicInteger();
    private final StringBuilder csv = new StringBuilder();

    @Override
    public String parseStrToStandard(String[] sentencesFromFile) {
        int headerCellsAmount = 0;
        int sentenceNumber = 1;

        for (String sentence : sentencesFromFile) {
            csv.append("Sentence ").append(sentenceNumber).append(";");
            sentenceNumber++;
            Arrays.stream(sentence.trim().split(" "))
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .forEach(word -> {
                        csv.append(word).append(";");
                        wordsInRecord.getAndIncrement();
                    });
            csv.append("\n");
            headerCellsAmount = Math.max(wordsInRecord.get(), headerCellsAmount);
            wordsInRecord.set(0);
        }
        csv.insert(0, addHeader(headerCellsAmount));

        return csv.toString();
    }

    private String addHeader(int headerCellsAmount) {
        StringBuilder header = new StringBuilder();
        header.append(";");
        for (int i = 1; i <= headerCellsAmount; i++) {
            header.append("Word ").append(i).append(";");
        }
        header.append("\n");

        return header.toString();
    }
}

