package uppgift3;

import java.util.Collections;
import java.util.List;

public class InsertSort {
  private List<Integer> l;

  public InsertSort(List<Integer> l) {
    int sz = l.size();

    for (int i = 0; i < sz; i++) {
      for (int j = i; j > 0; j--) {
        if (l.get(j) < l.get(j - 1)) {
          Collections.swap(l, j, j - 1);
        } else {
          break;
        }
      }
    }
    this.l = l;
  }

  public List<Integer> getList() {
    return l;
  }
}
