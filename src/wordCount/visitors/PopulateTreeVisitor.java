package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.MyLogger;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
/**
 * PopulateTreeVisitor - visitor class that reads words from a file and populates a tree data structure
 */
public class PopulateTreeVisitor implements Visitor {

    private static final int init_capacity = 1024;
    private static final float load = 0.75f;
    private static final int num_threads = Runtime.getRuntime().availableProcessors();
    
    private class Worker implements Runnable {
        private final String[] arr;

        private final int s;
        private final int e;

        private final ConcurrentHashMap<String, Integer> hashMap;

        public Worker(String[] arrIn, int sIn, int eIn, ConcurrentHashMap<String, Integer> hashMapIn) {
            arr = arrIn;
            s = sIn;
            e = eIn;
            hashMap = hashMapIn;
        }

        public void run() {
            for (int j =  s; j < e; j++) {
                hashMap.compute(arr[j], (key, value) -> (value == null) ? 1 : value + 1);
            }
        }

    }
    
    /**
     * visit - reads words from the file and visits the Tree in order to populate it
     *
     * @return none
     */ 
    public void visit(Tree tree) {

        MyLogger.printToStdout(3, "visit() in PopulateTreeVisitor called.");
        List<String> words = tree.getFileProcessor().readAllLines();
        String[] arr = words.toArray(new String[words.size()]);
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<String, Integer>(init_capacity, load, num_threads);
        Thread[] threads = new Thread[num_threads-1];
        int work = words.size()/num_threads;

        for (int i = 0; i < num_threads-1; i++) {
            threads[i] = new Thread(new Worker(arr, i*work, (i+1)*work, hashMap));
            threads[i].start();
        }

        Worker w = new Worker(arr, (num_threads-1)*work, words.size(), hashMap);
        w.run();
        try {
            for (Thread t: threads) {
                t.join();
            }
        } catch (Exception e) {
            System.exit(1);
        }

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
        tree.setTreeMap(treeMap);
    }

    /* single threaded */
    /* 
       public void visit(Tree tree) {

       MyLogger.printToStdout(3, "visit() in PopulateTreeVisitor called.");
       List<String> words = tree.getFileProcessor().readAllLines();

       HashMap<String, Integer> hashMap = new HashMap<String, Integer>(init_capacity, load);
       for(String word: words) {
       Integer temp = hashMap.put(word, 1);
       if (temp != null) {
       hashMap.put(word, temp + 1);
       } 
       }


       TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(hashMap);
       tree.setTreeMap(treeMap);
       }
       */
}
