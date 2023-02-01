//package se311.kwic;
package se311;
import se311.kwic.*;
import se311.search.*;

import java.util.*;

public class Controller {	
	
	public static void main(String[] args) {

		OptionReader.readOptions();

		//// KWIC Component
		
		// KWIC Input object
		se311.kwic.Input kwicInputObj = (se311.kwic.Input) OptionReader.getObjectFromKey("KWICInput");

		// Line Storage object
		LineStorage storageObj = (LineStorage) OptionReader.getObjectFromKey("Storage");
		//LineStorage storageObj = (LineStorage) inputObj.acceptInput();
		kwicInputObj.acceptInput(storageObj);

		// Shifter object
		Shifter shiftObj = (Shifter) OptionReader.getObjectFromKey("Shifter");
		shiftObj.init(storageObj);
		shiftObj.shiftAllLines();
		LineStorage shiftedLines = shiftObj.getShiftLines();

		// Sorter object
		Sorter sortObj = (Sorter) OptionReader.getObjectFromKey("Sorter");
		sortObj.sortLines(shiftedLines);
		ArrayList<KWICLine> sortedLines = sortObj.getSortedLines();

		// KWIC Output object
		se311.kwic.Output kwicOutputObj = (se311.kwic.Output) OptionReader.getObjectFromKey("KWICOutput");
		kwicOutputObj.outputLines(sortedLines);

		//// Search Component

		// Search Input object
		se311.search.Input searchInputObj = (se311.search.Input) OptionReader.getObjectFromKey("SearchInput");
		String keyword = searchInputObj.getKeyword();

		// Keyword Search object
		KeywordSearch searchObj = (KeywordSearch) OptionReader.getObjectFromKey("Search");
		ArrayList<KWICLine> linesWithKeyword = searchObj.searchForKeyword(keyword, sortedLines);

		// Search Output object and decorators (if requested)
		se311.search.Output searchOutputObj = (se311.search.Output) OptionReader.getObjectFromKey("SearchOutput");

		String addHeader = OptionReader.getString("AddHeader").toUpperCase();
		String addFooter = OptionReader.getString("AddFooter").toUpperCase();

		/*
			I could not get the below to work with the provided object loader since the constructors of the decorators require parameters
			The abstract decorator class and footer decorator constructors take one parameter & the header takes two
			The provided object loader does not give an option to accept constructors with parameters
			Also, because the Output Decorator is abstract, using an object loader will not allow me to access the extended methods of the header and footer
			I tried many methods and am quite unfamiliar with object loaders and decorators
			I expect this will dock my grade, but I can explain what issues I was getting if you would like for clarification
		 */
		if(addHeader.equals("YES")) {
			searchOutputObj = new Header(searchOutputObj, sortedLines.size());
		}
		if (addFooter.equals("YES")) {
			searchOutputObj = new Footer(searchOutputObj);
		}

		searchOutputObj.outputSearchResults(keyword, linesWithKeyword);
	
	}
}
	
