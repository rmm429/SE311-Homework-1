package se311.search;

import se311.kwic.KWICLine;

import java.util.ArrayList;

public class Header extends OutputDecorator {

    private int records;

    public Header(Output output, int recs) {
        super(output);
        records = recs;
    }

    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {
        outputHeader(linesWithKeyword.size());
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
    }

    private void outputHeader(int results) {
        System.out.println("[" + results + "] results are found in [" + records + "] records");
    }

}
