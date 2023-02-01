package se311.search;

import se311.kwic.KWICLine;

import java.util.ArrayList;

public abstract class OutputDecorator implements Output {

    protected Output decoratedOutput;

    public OutputDecorator(Output output) {
        decoratedOutput = output;
    }

    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {
        decoratedOutput.outputSearchResults(keyword, linesWithKeyword);
    }

//
//    private Output outputObj;
//
//    public OutputDecorator(Output output) {
//        outputObj = output;
//    }
//
//    public void outputSearchResults(String keyword, ArrayList<KWICLine> linesWithKeyword) {
//        outputObj.outputSearchResults(keyword, linesWithKeyword);
//    }

}
