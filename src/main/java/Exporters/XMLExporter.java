package Exporters;

import java.util.Arrays;

public class XMLExporter implements Exporter {

    @Override
    public String parseStrToStandard(String[] sentencesFromFile) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        xml.append("<text>");

        for (String sentence : sentencesFromFile) {
            xml.append("<sentence>");
            Arrays.stream(sentence.trim().split(" "))
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .forEach(word -> xml
                            .append("<word>")
                            .append(word)
                            .append("</word>"));

            xml.append("</sentence>");
        }

        xml.append("</text>");
        return xml.toString();
    }
}