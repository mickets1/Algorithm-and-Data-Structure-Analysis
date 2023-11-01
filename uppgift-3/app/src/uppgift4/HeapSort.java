package uppgift4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
  private int sz;
  private List<Integer> heap = new ArrayList<>();
  
  public HeapSort(List<Integer> l) {
    heap = l;
    this.heap.add(0, null);
    this.sz = heap.size() - 1;

    // System.out.println("Original: " + heap.toString());
  }

  public void sort() {
    int k = sz / 2;

    while (k >= 1) {
      sink(k);
      k--;
    }

    while (sz > 1) {
      // Swap first and last element.
      Collections.swap(heap, 1, sz);
      sz--;
      sink(1);
    }
  }

  private void sink(int k) {
    while (2 * k <= sz) {
      int j = 2 * k;

      if (j < sz && heap.get(j) < heap.get(j + 1)) {
        j++;
      }

      if (heap.get(k) > heap.get(j)) {
        break;
      }

      // Swap lesser for larger - Larger first.      
      Collections.swap(heap, k, j);
      // System.out.println(heap);

      k = j;
    }
  }

  public List<Integer> getHeap() {
    // Remove null element.
    heap.remove(0);
    return heap;
  }

  public int getHeapSize() {
    return heap.size();
  }
}
