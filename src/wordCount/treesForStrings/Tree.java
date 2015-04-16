package wordCount.treesForStrings;

import wordCount.visitors.Visitor;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;

/**
 * Tree - contains the tree data structure
 */
public class Tree {

	// private data member for tree data structure
	
	// getDataStructure method to access the data structure in the visitor classes
	
	private FileProcessor fileProcessor;

	/**
	 * Constructor - constructs a tree object
	 *
	 * @return none
	 */
	public Tree(FileProcessor fileProcessorIn) {

		MyLogger.printToStdout(2, "Constructor in Tree called.");

		fileProcessor = fileProcessorIn;

	}

	/**
	 * accept - allows the visitor to visit the Tree
	 *
	 * @return none
	 */
	public void accept(Visitor visitor) {
		
		MyLogger.printToStdout(3, "accept() in Tree called.");

		visitor.visit(this);

	}

	/**
	 * getFileProcessor - gets the FileProcessor
	 *
	 * @return fileProcessor the FileProcessor
	 */
	public FileProcessor getFileProcessor() {

		MyLogger.printToStdout(3, "getFileProcessor() in Tree called.");

		return fileProcessor;
	
	}

}
