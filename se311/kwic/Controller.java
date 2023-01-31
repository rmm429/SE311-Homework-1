package se311.kwic;

import java.util.*;

public class Controller {	
	
	public static void main(String[] args) {
		
		//Get input object
		
		OptionReader.readOptions();

		Input inputObj = (Input) OptionReader.getObjectFromKey("Input");

		//LineStorage storageObj = (LineStorage) inputObj.acceptInput();
		LineStorage storageObj = (LineStorage) OptionReader.getObjectFromKey("Storage");
		inputObj.acceptInput(storageObj);

		//Get shifter object
		Shifter shiftObj = (Shifter) OptionReader.getObjectFromKey("Shifter");

		shiftObj.init(storageObj);
		shiftObj.shiftAllLines();

//		for(KWICLine kwicLine:storageObj.getAllLines()) {
//			System.out.println(kwicLine.getLineAsString());
//		}
//		System.out.println();

//		ArrayList<KWICLine> shiftedLines = shiftObj.getShiftLines();
		LineStorage shiftedLines = shiftObj.getShiftLines();

		//Get sorter object
		Sorter sortObj = (Sorter) OptionReader.getObjectFromKey("Sorter");

		sortObj.sortLines(shiftedLines);
		ArrayList<KWICLine> sortedLines = sortObj.getSortedLines();

		//Get output object
		Output outputObj = (Output) OptionReader.getObjectFromKey("Output");
		outputObj.outputLines(sortedLines);

	
	}
}
	
