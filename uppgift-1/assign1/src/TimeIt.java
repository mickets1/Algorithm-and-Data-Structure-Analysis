import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// Uppgift 3
public class TimeIt {
    ArrayList<Double> avg = new ArrayList<>();
    Random random = new Random();

    // Quick union find
    public void calculateQuf (QUnionFind quf) {
      int size = 100000;

      int[] input = IntStream.rangeClosed(0, size - 1).toArray();
      quf.setInput(input);

      long startTime = System.nanoTime();
      for (int i = 0; i < size; i++) {
        int rndA = random.nextInt(size);
        int rndB = random.nextInt(size);
        
        quf.union(rndA, rndB);
        long estimatedTime = System.nanoTime() - startTime;

        double seconds = (double) estimatedTime / 1_000_000_000;
        System.out.println(seconds);

        this.avg.add(seconds);
      }
      calculateAverage();
  }

    // Weighted quick union find
    public void calculateWuqf(WQUnionFind wquf) {
        int size = 100000;

        int[] input = IntStream.rangeClosed(0, size - 1).toArray();
        int arr[] = new int[size];
        Arrays.fill(arr, 1);
        wquf.setInput(input, arr);

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
          int rndA = random.nextInt(size);
          int rndB = random.nextInt(size);

          wquf.union(rndA, rndB);
          long estimatedTime = System.nanoTime() - startTime;

          double seconds = (double) estimatedTime / 1_000_000_000;
          System.out.println(seconds);

          this.avg.add(seconds);
        }
        calculateAverage();
    }

    // Print 3sum brute force version
    public void threeSum(ThreeSum threeSum) {
        int size = 1000;

        int[] input = IntStream.rangeClosed(-size + 1, size - 1).toArray();

        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            threeSum.threeSum(input);
            long estimatedTime = System.nanoTime() - startTime;

            double seconds = (double) estimatedTime / 1_000_000_000;
            System.out.println(seconds);

            this.avg.add(seconds);
        }
        calculateAverage();
    }


    // Print 3sum pointer version 
    public void threeSumPointer(ThreeSumPointer threeSumPointer) {
        int size = 10000;

        for (int i = 0; i < 10; i++) {
            // New random array for each time measurement
            ArrayList<Integer> input = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                input.add(random.nextInt(size - (-size)) + (-size));
            }

            long startTime = System.nanoTime();
            threeSumPointer.threeSum(input);
            long estimatedTime = System.nanoTime() - startTime;

            double seconds = (double) estimatedTime / 1_000_000_000;
            System.out.println(seconds);

            this.avg.add(seconds);
        }
        calculateAverage();
    }

    private void calculateAverage() {
        double sum = 0;

        // Remove first value because of wrong/incorrect time.
        avg.remove(0);

        for (int i = 0; i < avg.size(); i++) {
            sum += this.avg.get(i);
        }

        System.out.println("Average: " + sum / this.avg.size());

        // Reset array
        this.avg = new ArrayList<>();
    }
}
