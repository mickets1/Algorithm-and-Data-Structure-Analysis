package uppgift4;

import java.util.Random;

public class AVLTest {
  private Random rnd = new Random();

  // 100 000 random inserts
  public void avlTest1() {
    AVLTree avlt = new AVLTree();

    int sz = 100_000;
    int sum = 0;
    long startTime = System.nanoTime();
    for (int i = 0; i < sz; i++) {
      int rndVal = rnd.nextInt(sz) + 1;
      
      avlt.add(rndVal);
      sum += avlt.height();
    }
    long estimatedTime = System.nanoTime() - startTime;
    double seconds = (double) estimatedTime / 1_000_000_000;
    
    System.out.println("Height: " + avlt.height());
    System.out.println("Nodes: " + avlt.getNodeCount(avlt.getRoot()));
    System.out.println("Mean: " + sum / (float) avlt.getNodeCount(avlt.getRoot()));
    System.out.println("Execution time: " + seconds + " seconds");
  }

    // 100 000 random inserts
    public void bstTest1() {
      BST t = new BST();
  
      int sz = 100_000;
      int sum = 0;
      long startTime = System.nanoTime();
      for (int i = 0; i < sz; i++) {
        int rndVal = rnd.nextInt(sz) + 1;
        
        t.add(rndVal);
        sum += t.height();
      }
      long estimatedTime = System.nanoTime() - startTime;
      double seconds = (double) estimatedTime / 1_000_000_000;

      System.out.println("Height: " + t.height());
      System.out.println("Nodes: " + t.getNodeCount(t.getRoot()));
      System.out.println("Mean: " + sum / (float) t.getNodeCount(t.getRoot()));
      System.out.println("Execution time: " + seconds + " seconds");
    }



  // 100 000 random inserts and deletes.
  public void avlTest2() {
    AVLTree avlt = new AVLTree();

    int sz = 100_000;
    int sum = 0;
    long startTime = System.nanoTime();
    for (int i = 0; i < sz; i++) {
      int rndVal = rnd.nextInt(sz) + 1;
      
      avlt.add(rndVal);
      sum += avlt.height();
      
      int rndVal2 = rnd.nextInt(sz) + 1;
      avlt.remove(rndVal2);
    }
    long estimatedTime = System.nanoTime() - startTime;
    double seconds = (double) estimatedTime / 1_000_000_000;

    System.out.println("Height: " + avlt.height());
    System.out.println("Nodes: " + avlt.getNodeCount(avlt.getRoot()));
    System.out.println("Mean: " + sum / (float) avlt.getNodeCount(avlt.getRoot()));
    System.out.println("Execution time: " + seconds + " seconds");
  }

  // 100 000 random inserts and deletes.
  public void bstTest2() {
    BST t = new BST();

    int sz = 100_000;
    int sum = 0;
    long startTime = System.nanoTime();
    for (int i = 0; i < sz; i++) {
      int rndVal = rnd.nextInt(sz) + 1;
      
      t.add(rndVal);
      sum += t.height();

      int rndVal2 = rnd.nextInt(sz) + 1;
      t.remove(rndVal2);
    }
    long estimatedTime = System.nanoTime() - startTime;
    double seconds = (double) estimatedTime / 1_000_000_000;

    System.out.println("Height: " + t.height());
    System.out.println("Nodes: " + t.getNodeCount(t.getRoot()));
    System.out.println("Mean: " + sum / (float) t.getNodeCount(t.getRoot()));
    System.out.println("Execution time: " + seconds + " seconds");
  }
}
