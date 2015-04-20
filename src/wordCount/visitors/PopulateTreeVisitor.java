package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.MyLogger;

import java.util.TreeMap;
import java.util.List;
import java.util.function.BiFunction;
/**
 * PopulateTreeVisitor - visitor class that reads words from a file and populates a tree data structure
 */
public class PopulateTreeVisitor implements Visitor {


	/**
	 * visit - reads words from the file and visits the Tree in order to populate it
	 *
	 * @return none
	 */
	public void visit(Tree tree) {

		MyLogger.printToStdout(3, "visit() in PopulateTreeVisitor called.");
        List<String> words = tree.getFileProcessor().readAllLines();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        for(String word: words) {
            treeMap.compute(word, (key, value) -> (value == null) ? 1 : value + 1);
        }
        tree.setTreeMap(treeMap);
	}
}
