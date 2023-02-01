package se311.kwic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput implements Input {

    //@Override
    public void acceptInput(LineStorage storageObj) {

        String inputFile = OptionReader.getString("KWICInputFileName");

        try {

            Scanner scanner = new Scanner(new File(inputFile));

            while (scanner.hasNextLine()) {
                storageObj.addOneLine(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found!");
        }

    }

}
