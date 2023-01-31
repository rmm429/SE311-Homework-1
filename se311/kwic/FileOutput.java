package se311.kwic;

import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOutput implements Output {

    public void outputLines(ArrayList<KWICLine> lines) {

        String outputFile = OptionReader.getString("OutputFileName");

        try {

            FileWriter fileWriter = new FileWriter(outputFile, false);

            for(int i = 0; i < lines.size(); i++) {
                fileWriter.write(lines.get(i).getLineAsString());
                if(i != lines.size() - 1) {
                    fileWriter.write("\n");
                }
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
