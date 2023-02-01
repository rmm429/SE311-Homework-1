package se311.kwic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class KWICLine {

    private ArrayList<String> wordList;
    private String originalLine;

    // instead of storing each original line, point to an instance of the original KWIC line

    public KWICLine(String oriLine) {

        originalLine = oriLine;
        //oriLine = oriLine.replaceAll("\\p{Punct}", "");
        String oriLineNoPunct = oriLine.replaceAll("[,.?;!]", "");

        // ----ASK IF I SHOULD DO THIS HERE OR CREATE A METHOD TO DO IT THAT IS TO BE CALLED OUTSIDE OF THIS CLASS---------
        wordList = new ArrayList<>();
        String[] wordArr = oriLineNoPunct.split(" ");
        Collections.addAll(wordList, wordArr);

    }

//    public KWICLine(String[] wordArr) {
    public KWICLine(ArrayList<String> wrdLst) {

//        wordList = new ArrayList<>();
//        Collections.addAll(wordList, wordArr);
        wordList = wrdLst;


        // ----ASK IF I SHOULD DO THIS HERE OR CREATE A METHOD TO DO IT THAT IS TO BE CALLED OUTSIDE OF THIS CLASS---------
//        originalLine = String.join(" ", wordArr);
        originalLine = String.join(" ", wrdLst);

    }

//    public KWICLine(String oriLine, String[] wordArr) {
    public KWICLine(String oriLine, ArrayList<String> wrdLst) {

        originalLine = oriLine;

//        wordList = new ArrayList<>();
//        Collections.addAll(wordList, wordArr);
        wordList = wrdLst;

    }

//    public void createWordListFromOriLine() {
//
//        String[] wordArr = getOriLine().split(" ");
//        Collections.addAll(wordList, wordArr);
//
//    }

    public void insertWord(int index, String word) {
        wordList.add(index, word);
    }

    public void appendWord(String word) {
        wordList.add(word);
    }

    public void delWord(int index) {
        wordList.remove(index);
    }

    public String getWord(int index) {
        return wordList.get(index);
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public String getOriLine() {
        return originalLine;
    }

    public int wordCount() {
        return wordList.size();
    }

    public String getLineAsString() {
        return String.join(" ", getWordList());
    }

    public KWICLine clone() {
//        return new KWICLine(getOriLine(), getWordList().toArray(new String[0]).clone());
        return new KWICLine(getOriLine(), (ArrayList<String>) getWordList().clone());
    }

}
