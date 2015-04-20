package wordCount.driver;

import wordCount.treesForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.visitors.Visitor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.WordCountVisitor;

/**
 * Driver - tests the wordCount program
 */
public class Driver {

	public static void main(String args[]) {

		// validate command line arguments for input and output file names

		if (args.length < 2) {
			System.err.println("Usage: to run, edit the build.xml file to enter args\nOr refer to the README.txt for proper usage!");
			System.exit(1);
		}

		try {
			Integer.parseInt(args[2]);
		} catch (NumberFormatException e) {
			System.err.println("Third parameter must be an integer!");
			System.exit(1);
		} finally {

		}

		try {
			Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			System.err.println("Fourth parameter must be an integer!");
			System.exit(1);
		} finally {

		}

		String inputFile = args[0];
		String outputFile = args[1];
		int n = Integer.parseInt(args[2]);
		int myLoggerValue = Integer.parseInt(args[3]);

		long startTime = System.currentTimeMillis();

		// start of N loop

		for (int i = 0; i < n; i++) {

			// declare / instantiate the tree and visitors
		    FileProcessor fileProcessor = new FileProcessor(inputFile, outputFile);
		    Tree tree = new Tree(fileProcessor);
            Visitor populateTreeVisitor = new PopulateTreeVisitor();
            Visitor wordCountVisitor = new WordCountVisitor();
			// code to visit with the PopulateVisitor

			tree.accept(populateTreeVisitor);
			
			// code to visit with the WordCountVisitor

			tree.accept(wordCountVisitor);

		// end of loop N times

		}

		long finishTime = System.currentTimeMillis();

		long total_time = (finishTime - startTime) / n;

		System.out.println("Total iteration time: " + total_time + " millisecond.");

		// debug

		//String total_time_string = Long.toString(total_time);

		//fileProcessor.writeToFile(total_time_string, outputFile);

	}
}
