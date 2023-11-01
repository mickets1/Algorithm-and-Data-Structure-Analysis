import java.util.ArrayList;
import java.util.Collections;

// Uppgift 2
// Not handling duplicates.
public class ThreeSumPointer {
    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> threeSum(ArrayList<Integer> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            twoSum(list, i);
        }

        return this.res;
    }

    private void twoSum(ArrayList<Integer> list, int i) {
        int fp = i + 1;
        int bp = list.size() - 1;

        while (fp < bp) {
            int p = list.get(i) + list.get(fp) + list.get(bp);
            
            if (p == 0) {
                res.add(list.get(i));
                res.add(list.get(fp));
                res.add(list.get(bp));
                fp++;
            } else if (p < 0) {
                fp++;
            } else {
                bp--;
            }
        }
    }
}
