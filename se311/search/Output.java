package se311.search;

import se311.kwic.KWICLine;

import java.util.ArrayList;

public interface Output {

    void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword);

}
