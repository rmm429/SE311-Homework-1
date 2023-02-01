package se311.search;

import se311.kwic.KWICLine;
import java.util.ArrayList;

public class KeywordSearch {

    private ArrayList<KWICLine> linesWithKeyword;

    public KeywordSearch() {
        linesWithKeyword = new ArrayList<>();
    }

    public ArrayList<KWICLine> searchForKeyword(String keyword, ArrayList<KWICLine> sortedLines) {

        for(KWICLine line:sortedLines) {
            if (line.getWordList().contains(keyword)) { // Case-sensitive
                linesWithKeyword.add(line);
            }
        }

        return linesWithKeyword;

    }

}
