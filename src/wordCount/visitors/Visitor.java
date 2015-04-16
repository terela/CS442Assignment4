package wordCount.visitors;

import wordCount.treesForStrings.Tree;

/**
 * Visitor - interface which contains visit methods for each element
 */
public interface Visitor {

	/**
	 * visit - implemented in each of the visitor classes in order to visit the Tree
	 *
	 * @return none
	 */
	public void visit(Tree tree);

}
