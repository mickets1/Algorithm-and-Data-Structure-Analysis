package uppgift3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class RndQueue implements Iterable<Integer> {
  private Random rnd = new Random();
  private int size;
  private int[] queue;

  public RndQueue() {
    queue = new int[1];
    this.size = 0;
  }

  @Override
    public Iterator<Integer> iterator() {
        return new RndQueueIterator(this);
    }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void enqueue(int v) {
    // if queue is full extend it
    if (size == queue.length) {
      extendQueue();
    }

    queue[size++] = v;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    int rndVal = rnd.nextInt(size);
    int dequeuedVal = queue[rndVal];

    // Switch element with last element
    queue[rndVal] = queue[--size];
    
    return dequeuedVal;
  }

  // Doubles array size when queue is full
  public void extendQueue() {
    // Deep copy when used with primitives.
    queue = Arrays.copyOf(queue, queue.length * 2);
  }

  public int[] getQueue() {
    return Arrays.copyOf(queue, size);
  }
}
