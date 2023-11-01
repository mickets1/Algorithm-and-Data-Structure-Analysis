import java.util.ArrayList;

// Uppgift 1
public class ThreeSum {

    // Brute force version of 3sum(keeping duplicates). 
    public ArrayList<Integer> threeSum (int[] input) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                for (int k = 0; k < input.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    if (input[i] + input[j] + input[k] == 0) {
                        res.add(input[i]);
                        res.add(input[j]);
                        res.add(input[k]);
                    }
                }
            }
        }
        return res;
    }
}
