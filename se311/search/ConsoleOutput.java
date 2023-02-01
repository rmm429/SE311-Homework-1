package se311.search;

import se311.kwic.KWICLine;

import java.util.ArrayList;

public class ConsoleOutput implements Output{

    // ANSI string colorization codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";


    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {

        if(linesWithKeyword.isEmpty()) {
            System.out.println("[" + ANSI_RED + keyword + ANSI_RESET + "] not found");
        } else {
            for(KWICLine line:linesWithKeyword) {
                String lineAsString = line.getLineAsString();
                System.out.println(lineAsString.replace(keyword, ANSI_RED + keyword + ANSI_RESET));
            }
        }

    }

}
