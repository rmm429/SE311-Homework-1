package se311.kwic;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicLineStorage implements LineStorage {

    //private HashMap<String, KWICLine> storedLines;
    private ArrayList<KWICLine> storedLines;

    public BasicLineStorage() {
        storedLines = new ArrayList<>();
    }

    public void addOneLine(String line) {

        KWICLine curKWICLine = new KWICLine(line);

//        for(String word:curKWICLine.getWordList()) {
//            System.out.println("\n" + word);
//        }

        // System.out.println("Words: " + curKWICLine.wordCount());
        storedLines.add(curKWICLine);

    }

    public void addKWICLine(KWICLine line) {
        storedLines.add(line);
    }

    public KWICLine getOneLine(int index) {
        return storedLines.get(index);
    }

    public ArrayList<KWICLine> getAllLines() {
        return storedLines;
    }

    public int countTotalLines() {
        return storedLines.size();
    }

}
