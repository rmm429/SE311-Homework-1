package se311.kwic;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

    private ArrayList<KWICLine> lines;

    public void sortLines(LineStorage shiftedLines) {

        lines = shiftedLines.getAllLines();

        int lineCount = lines.size();

        for (int i = 0; i < lineCount; i++) {

            for (int j = i + 1; j < lineCount; j++) {
                String curLine = lines.get(i).getLineAsString();
                String nextLine =  lines.get(j).getLineAsString();

                if(curLine.compareTo(nextLine) > 0) {
                    Collections.swap(lines, i, j);
                }
            }

        }
    }

    public ArrayList<KWICLine> getSortedLines() {
        return lines;
    }

}
