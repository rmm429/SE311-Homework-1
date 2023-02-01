package se311.search;

import se311.kwic.KWICLine;
import java.util.ArrayList;

public class Header extends OutputDecorator {

    private int records;

    // accepts the total number of records upon construction
    public Header(Output output, int recs) {
        super(output);
        records = recs;
    }

    /**
     * Output the header and the search results
     *
     * @param	keyword             the user-inputted keyword
     * @param	linesWithKeyword    all of the lines that contain the keyword
     */
    @Override
    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {
        outputHeader(linesWithKeyword.size());
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
    }

    /**
     * Outputs the number of results within the total number of records as a header to the search results
     *
     */
    private void outputHeader(int results) {
        System.out.println("[" + results + "] results are found in [" + records + "] records");
    }

}
