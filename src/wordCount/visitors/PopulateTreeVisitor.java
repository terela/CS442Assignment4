package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.MyLogger;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * PopulateTreeVisitor - visitor class that reads words from a file and populates a tree data structure
 */
public class PopulateTreeVisitor implements Visitor {

	private String inputFile;

	/**
	 * visit - reads words from the file and visits the Tree in order to populate it
	 *
	 * @return none
	 */
	public void visit(Tree tree) {

		MyLogger.printToStdout(3, "visit() in PopulateTreeVisitor called.");

		inputFile = tree.getFileProcessor().getInputFile();

		String line = null;

		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				// add line to data structure
				// dataStructure.add(tree.getFileProcessor().readLine());

				// temp break statement to exit while loop
				break;

			}

			bufferedReader.close();

		} catch (IOException e) {

			MyLogger.printToStdout(0, "Error message in PopulateTreeVisitor called.");

			e.printStackTrace();

			System.exit(1);

		} finally {

		}
		
	}

}
