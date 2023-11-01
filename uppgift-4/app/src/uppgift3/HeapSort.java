package uppgift3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort {
  private List<Integer> heap = new ArrayList<>();

  public HeapSort() {
    this.heap.add(null);
  }

  public void heapPush(int value) {
    heap.add(value);
    swim(heap.size() - 1);
  }

  public int heapPop() {
    int min = heap.get(1);
    Collections.swap(heap, 1, heap.size() - 1);
    heap.remove(heap.size() - 1);
    sink(1);
    return min;
  }

  private void swim(int k) {
    while (k > 1 && heap.get(k / 2) < heap.get(k)) {
      Collections.swap(heap, k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= heap.size() - 1) {
      int j = 2 * k;

      if (j < heap.size() - 1 && heap.get(j) < heap.get(j + 1)) {
        j++;
      }

      if (heap.get(k) > heap.get(j)) {
        break;
      }

      Collections.swap(heap, k, j);
      k = j;
    }
  }

  public List<Integer> getHeap() {
    heap.remove(0);
    return heap;
  }

  public int getHeapSize() {
    return heap.size() - 1;
  }
}
