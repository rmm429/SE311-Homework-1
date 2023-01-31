package se311.kwic;

import java.util.ArrayList;

public class ConsoleOutput implements Output {

    public void outputLines(ArrayList<KWICLine> lines) {

        for(KWICLine line:lines) {
            System.out.println(line.getLineAsString());
        }

    }

}
