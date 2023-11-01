package uppgift3;

import java.util.Random;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RndQueueIterator implements Iterator<Integer> {
  private int[] queueCopy;
  private int currentIndex = 0;

  public RndQueueIterator(RndQueue q){
    int[] qCopy = new int[q.size()];
    // Random order
    System.arraycopy(q.getQueue(), 0, qCopy, 0, q.size());
    shuffleArray(qCopy);

    this.queueCopy = qCopy;
  }

  @Override
  public boolean hasNext() {
    return queueCopy.length > currentIndex;
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      throw new NoSuchElementException("Queue is empty");
    }

    return queueCopy[currentIndex++];
  }

  // Fisher-yates shuffle algorithm.
  private void shuffleArray(int[] array) {
    Random rnd = new Random();
    for (int i = array.length - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1);
        int temp = array[index];
        array[index] = array[i];
        array[i] = temp;
    }
  }
}