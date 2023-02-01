package se311.search;

import se311.kwic.KWICLine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Footer extends OutputDecorator {

    public Footer(Output output) {
        super(output);
    }

    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
        outputFooter();
    }

    private void outputFooter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

}
