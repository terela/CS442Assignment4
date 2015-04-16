package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.MyLogger;

/**
 * WordCountVisitor - visitor that determines the total number of words and characters in the tree and stores them in output file
 */
public class WordCountVisitor implements Visitor {

	/**
	 * visit - visits the Tree in order to find the number of words and characters contained within it
	 *
	 * @return none
	 */
	public void visit(Tree tree) {

		MyLogger.printToStdout(3, "visit() in WordCountVisitor called.");

		// count the number of words and characters in the tree and write the values to the output file

	}

}
