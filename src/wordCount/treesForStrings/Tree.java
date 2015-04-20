package wordCount.treesForStrings;

import wordCount.visitors.Visitor;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;

import java.util.TreeMap; 
/**
 * Tree - contains the tree data structure
 */
public class Tree {

	// private data member for tree data structure
	
	// getDataStructure method to access the data structure in the visitor classes
	
	private FileProcessor fileProcessor;
    private TreeMap<String, Integer> treeMap;

    

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

	/**
	 * setFileProcessor - sets the FileProcessor
	 *
	 * @return none
	 */
    public void setFileProcessor(FileProcessor fileProcessorIn) {
        
        MyLogger.printToStdout(3, "setFileProcessor() in Tree called.");
        
        fileProcessor = fileProcessorIn;

    }

	/**
	 * getTreeMap - gets the TreeMap
	 *
	 * @return treeMap the TreeMap
	 */
	public TreeMap<String, Integer> getTreeMap() {

		MyLogger.printToStdout(3, "getTreeMap() in Tree called.");

		return treeMap;
	
	}

	/**
	 * setTreeMap - sets the TreeMap
	 *
	 * @return none
	 */
    public void setTreeMap(TreeMap<String, Integer> treeMapIn) {
        
        MyLogger.printToStdout(3, "setTreeMap() in Tree called.");
        
        treeMap = treeMapIn;
    
    }
}
