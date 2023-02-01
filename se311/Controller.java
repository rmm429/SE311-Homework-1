//package se311.kwic;
package se311;
import se311.kwic.*;
import se311.search.*;

import java.util.*;

public class Controller {	
	
	public static void main(String[] args) {

		// KWIC Component
		
		//Get input object
		
		OptionReader.readOptions();

		se311.kwic.Input kwicInputObj = (se311.kwic.Input) OptionReader.getObjectFromKey("KWICInput");

		//LineStorage storageObj = (LineStorage) inputObj.acceptInput();
		LineStorage storageObj = (LineStorage) OptionReader.getObjectFromKey("Storage");
		kwicInputObj.acceptInput(storageObj);

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
		se311.kwic.Output kwicOutputObj = (se311.kwic.Output) OptionReader.getObjectFromKey("KWICOutput");
		kwicOutputObj.outputLines(sortedLines);

		// Search Component

		se311.search.Input searchInputObj = (se311.search.Input) OptionReader.getObjectFromKey("SearchInput");
		String keyword = searchInputObj.getKeyword();

		KeywordSearch searchObj = (KeywordSearch) OptionReader.getObjectFromKey("Search");
		ArrayList<KWICLine> linesWithKeyword = searchObj.searchForKeyword(keyword, sortedLines);

		se311.search.Output searchOutputObj = (se311.search.Output) OptionReader.getObjectFromKey("SearchOutput");
		searchOutputObj = new Header(searchOutputObj, sortedLines.size());
		searchOutputObj = new Footer(searchOutputObj);
		searchOutputObj.outputSearchResults(keyword, linesWithKeyword);



	
	}
}
	
