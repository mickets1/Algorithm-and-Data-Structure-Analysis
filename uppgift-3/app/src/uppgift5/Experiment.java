package uppgift5;

import java.util.ArrayList;

public class Experiment {
  public  ArrayList<Integer> generateRandomInput(int size) {
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        input.add(i);
    }
    
    return input;
  }

  public void runExperiment(ArrayList<Integer> input, int depth) {
      ArrayList<Integer> copyInput = new ArrayList<>(input);

      // Perform QuickSort with InsertSort and HeapSort options
      QuickSort qs = new QuickSort(copyInput, depth);
      int high = copyInput.size() - 1;
      int low = 0;
      qs.calculatePivot(low, high);
      qs.sort(low, high);

      System.out.println("Median pivot value = " + qs.getMedianPivot());
  }
}
