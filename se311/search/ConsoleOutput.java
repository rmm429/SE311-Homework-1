package se311.search;

import se311.kwic.KWICLine;
import java.util.ArrayList;

public class ConsoleOutput implements Output{

    // ANSI string colorization codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Outputs the result of searching for lines with the provided keyword
     *
     * @param	keyword             the user-inputted keyword
     * @param	linesWithKeyword    all of the lines that contain the keyword
     */
    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {

        if(linesWithKeyword.isEmpty()) { // keyword not found
            System.out.println("[" + ANSI_RED + keyword + ANSI_RESET + "] not found");
        } else {
            for(KWICLine line:linesWithKeyword) {
                String lineAsString = line.getLineAsString();
                System.out.println(lineAsString.replace(keyword, ANSI_RED + keyword + ANSI_RESET));
            }
        }

    }

}
