This project is a Keyword-in-Context (KWIC) searcher.
This version utilizes modules for each of the components of the KWIC sorting as well as for input, search, and output.
When the program is started, it will prompt the user to enter lines that will be KWIC-sorted and stored for use.
Then, the user can search for a keyword that is stored within the KWIC-sorted lines repository.

To run the program, run the Controller.java file in the "se311" folder.
The main() method is included here.

Notes for grader:
	
	The only hiccup I encountered that persisted in my submitted program is using the object loader for the search decorators.
	I could not get the below to work with the provided object loader since the constructors of the decorators require parameters.
	The abstract decorator class and footer decorator constructors take one parameter & the header takes two.
	The provided object loader does not give an option to accept constructors with parameters.
	Also, because the Output Decorator is abstract, using an object loader will not allow me to access the extended methods of the header and footer.
	I have included comments in the Controller.java file where this occurred.

config.properites:

	The config.properties file contains all the settings for input and output.
	This file can be found in the root directory.

	The KWICInputFileName and KWICOutputFileName values can be set to change what files the program reads from and writes to.
	By default, these values are "SampleInputFile.txt" anb "SampleOutputFile.txt" respectively.
	I have provided both of these files, but the content or the files themselves can be changed.

	If you would like to use files, change the KWICInput and KWICOutput values to "FileInput" and "FileOutput" respectively.
	However, if you would like to input and output to console, change the KWICInput and KWICOutput values to "ConsoleInput" and "ConsoleOutput" respectively.
	These values can be mixed-and-matched.

	The search output can be decorated with a header and/or footer.
	To choose whether to decorate or not, set the value of AddHeader and AddFooter to "yes" or "no" respectively.
	These can be mixed-and-matched.

Case-sensitivity and punctuation:

	The alphabetizing sorter implemented in Sorter.java ignores case-sensitivity to sort the lines.
	This means that uppercase and lowercase letters are treated equally.

	However, the search implementation in KeywordSearch.java is case-sensitive.
	This means, for example, that searching for the keyword "hello" when lines contains "Hello" will not provide any results.

	Additionally, certain punctuation is stripped from the stored lines.
	This punctuation includes a period, comma, semicolon, question mark, and exclamation point [.,;?!].
	For example, "hello, how are you?" will be changed to "hello how are you".
	So, when searching for entered words, this specific punctuation can be omitted.

Soruces used to assist development:

	Array to ArrayList: https://www.geeksforgeeks.org/conversion-of-array-to-arraylist-in-java/
	String to Array: https://www.java67.com/2017/09/how-to-convert-comma-separated-string-to-ArrayList-in-java-example.html
	Regex replace in String: https://www.tutorialspoint.com/javaregex/javaregex_matcher_replaceall.htm
	Scanner for file input: https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
	Swapping elements in an ArrayList: https://howtodoinjava.com/java/collections/arraylist/swap-two-elements-arraylist/
	FileWriter for file output: https://www.geeksforgeeks.org/filewriter-class-in-java/
	Keyword highlighting: https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/amp/
	Decorator Patterns in Java: https://www.developer.com/design/implementing-decorator-patterns-in-java/
	Get Time and Date in Java: https://www.javatpoint.com/java-get-current-date
