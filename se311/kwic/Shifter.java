package se311.kwic;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Shifter {

    protected LineStorage stored;

    public void init(LineStorage storageObj) {
        stored = storageObj;
    }

    public void shiftAllLines() {

        int lineCount = stored.countTotalLines();
        for(int i = 0; i < lineCount; i++) {

            // System.out.println(stored.getOneLine(i).getOriLine() + "\n");
            // KWICLine curLine = new KWICLine(stored.getOneLine(i));
            KWICLine oldLine = stored.getOneLine(i).clone();
            int wordCount = oldLine.wordCount();

            for (int j = 1; j < wordCount; j++) {

                KWICLine newLine = oldLine.clone();
                String lastWord = newLine.getWord(wordCount - 1);
                newLine.insertWord(0, lastWord);
                newLine.delWord(wordCount);
                stored.addKWICLine(newLine);
                oldLine = newLine;

            }

        }

//        for(KWICLine kwicLine:stored.getAllLines()) {
//
//            for(String line:kwicLine.getWordList()) {
//                System.out.print(line + " ");
//            }
//            System.out.println();
//
//        }


//        int origLineCount = stored.countTotalLines();
//        for(int i = 0; i < origLineCount; i++) {
//
//            KWICLine curLine = stored.getOneLine(i);
//            int wordCount = curLine.wordCount();
//
//            String lastWord = curLine.getWord(wordCount - 1);
//            curLine.insertWord(0, lastWord);
//            curLine.delWord(wordCount - 1);
//
//            for(String word:curLine.getWordList()) {
//                System.out.println(word);
//            }
//
//
//        }



    }

    public LineStorage getShiftLines() {
        return stored;
    }

}
