package uppgift5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import uppgift3.InsertSort;
import uppgift4.HeapSort;

public class QuickSort {
  private ArrayList<Integer> a = new ArrayList<>();
  private int medianPivot;
  private int sz;
  private int depth;

  public QuickSort(ArrayList<Integer> list, int depth) {
    Collections.shuffle(list);
    a = list;
    sz = list.size();
    this.depth = depth;
  }

  // Median of three
  public int calculatePivot(int lo, int hi) {
    int mid = hi / 2;
    
    int[] arr = {a.get(lo), a.get(mid), a.get(hi)};
    Arrays.sort(arr);

    this.medianPivot = arr[1];
    return arr[1];
  }
    
  private int partition(int lo, int hi) {
    int i = lo;
    int j = hi + 1;

    while (true) {
      i++;

      while (a.get(i) < a.get(lo)) {
        if (i == hi) {
          break;
        }
        i++;
      }

      j--;
      while (a.get(lo) < a.get(j)) {
        if (j == lo) {
          break;
        }
        j--;
      }

      if (i >= j) {
        break;
      }

      Collections.swap(a, i, j);
    }

    // Swap pivot and end.
    Collections.swap(a, lo, j);
    return j;
  }

  public void sort(int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    if (sz < 11) {
      System.out.println("Insert sort: ");
      new InsertSort(a);
      return;
    }

    if (depth == 0) {
      System.out.println("Heap Sort: ");

      // List of values not yet sorted.
      List<Integer> l = a.subList(lo, a.size());
      HeapSort heap = new HeapSort(l);
      heap.sort();

      // Combine the sorted lists.
      ArrayList<Integer> nl = new ArrayList<>();
      nl.addAll(a.subList(0, lo));
      nl.addAll(heap.getHeap());
      return;
    }

    depth--;

    int j = partition(lo, hi);
    sort(lo, j - 1);
    sort(j + 1, hi);
  }

  public ArrayList<Integer> getList() {
    return a;
  }

  public int getMedianPivot() {
    return medianPivot;
  }
}
