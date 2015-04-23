package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.MyLogger;

import java.util.Map;
import java.util.ArrayList;

/**
 * WordCountVisitor - visitor that determines the total number of words and characters in the tree and stores them in output file
 */
public class WordCountVisitor implements Visitor {

    private static final int num_threads = Runtime.getRuntime().availableProcessors();

    private class Worker implements Runnable {
        private final ArrayList<Map.Entry<String, Integer>> arr;

        private final int s;
        private final int e;
        public int numWords;
        public int numChar;

        public Worker(ArrayList<Map.Entry<String, Integer>> arrIn, int sIn, int eIn) {
            arr = arrIn;
            s = sIn;
            e = eIn;
            numWords = 0;
            numChar  = 0;
        }

        public void run() {
            for (int j = s; j < e; j++) {
                int val = arr.get(j).getValue();
                numWords += val;
                numChar += val * arr.get(j).getKey().length();
            }
        }

    }
	/**
	 * visit - visits the Tree in order to find the number of words and characters contained within it
	 *
	 * @return none
	 */
	public void visit(Tree tree) {

		MyLogger.printToStdout(3, "visit() in WordCountVisitor called.");

		// count the number of words and characters in the tree and write the values to the output file
        int numUnique = tree.getTreeMap().size();

        ArrayList<Map.Entry<String, Integer>> arr =  new ArrayList<Map.Entry<String, Integer>>(tree.getTreeMap().entrySet());


        Thread[] threads = new Thread[num_threads-1];
        Worker[] workers = new Worker[num_threads];

        int work = numUnique/num_threads;

        for (int i = 0; i < num_threads-1; i++) {
            workers[i] = new Worker(arr, i*work, (i+1)*work);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        workers[num_threads-1] = new Worker(arr, (num_threads-1)*work, numUnique);
        workers[num_threads-1].run();

        try {
            for (Thread t: threads) {
                t.join();
            }
        } catch (Exception e) {
			MyLogger.printToStdout(0, "Error message in WordCountVisitor called.");
			e.printStackTrace();
            System.exit(1);
        }

        int numWords = 0;
        int numChar = 0;
        for (Worker w: workers) {
            numWords += w.numWords;
            numChar += w.numChar;
        }

        tree.getFileProcessor().writeToFile(String.format("%d%n%d%n%d%n", numWords, numUnique, numChar));
	}
//	public void visit(Tree tree) {
//
//		MyLogger.printToStdout(3, "visit() in WordCountVisitor called.");
//
//		// count the number of words and characters in the tree and write the values to the output file
//        int numWords = 0;
//        int numUnique = tree.getTreeMap().size();
//        int numChar = 0;
//
//        for (Map.Entry<String, Integer> i: tree.getTreeMap().entrySet()) {
//            int val = i.getValue();
//            numWords += val;
//            numChar += val * i.getKey().length();
//        }
//
//        tree.getFileProcessor().writeToFile(String.format("%d%n%d%n%d%n", numWords, numUnique, numChar));
//	}

}

