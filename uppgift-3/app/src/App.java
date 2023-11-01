import uppgift1.HashTableQP;
import uppgift2.DataSet;
import uppgift3.InsertSort;
import uppgift4.HeapSort;
import uppgift5.Experiment;
import uppgift5.QuickSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class App {
  public static void main(String[] args) throws Exception {
    // Uppgift 1 - 2
    // Report in Readme.md
    DataSet data = new DataSet();
    String[] set = data.generateRegistrationNumbers(31);

    HashTableQP htqp = new HashTableQP(set.length);

    int totalCollisions = 0;
    int maxCollisions = 0;

    for (int i = 0; i < set.length; i++) {
      int ins = htqp.insert(set[i]);
      totalCollisions += ins;

      if (ins > maxCollisions) {
        maxCollisions = ins;
      }

      // if we want to print specific collisions.
      // System.out.println(htqp.insert(set[i]));

      if (ins == -1) {
        System.out.println("\nTable is half-full\n");
        break;
      }
    }

    
    System.out.println("Value to find: " + set[0]);
    System.out.println("Found?: " + htqp.find(set[0]));
    System.out.println("Table length: " + htqp.getLength());
    System.out.println("Average collisions per insertion: " + (double) totalCollisions / set.length);
    System.out.println("Max collisions for a single insertion: " + maxCollisions);
    System.out.println("Total collisions: " + htqp.getCollisions());

    // Uppgift 3
    // ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(5, 6, 9, 27, 18, -20));
    // InsertSort is =  new InsertSort(input);
    // System.out.println(is.getList());



    // Uppgift 4
    // ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 4, 8, 2, 5, 9, 3, 7, 6));
    // HeapSort heap = new HeapSort(input);
    // heap.sort();
    // System.out.println("Sorted: " + heap.getHeap());

    

    // Uppgift 5
  //   ArrayList<Integer> inputSizes = new ArrayList<>(Arrays.asList(10, 5, 10, 50, 15));
  //   ArrayList<Integer> depthValues = new ArrayList<>(Arrays.asList(4, 7, 8, 10));

  //   Experiment exp = new Experiment();
  //   for (int inputSize : inputSizes) {
  //       ArrayList<Integer> input = exp.generateRandomInput(inputSize);

  //       for (int depth : depthValues) {
  //           System.out.println("Input Size: " + inputSize + " | Depth: " + depth);
  //           exp.runExperiment(input, depth);
  //           System.out.println();
  //       }
  //       System.out.println("--------------------------------");
  //   }
  }
}
