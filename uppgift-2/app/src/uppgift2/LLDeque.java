package uppgift2;

import java.util.Iterator;

// Uppgift 2
public class LLDeque<T> implements Iterable<T> {
  private LLNode<T> head;
  private LLNode<T> tail;
    
   public LLDeque() {
      this.head = null;
      this.tail = null;
    }

    public void addFirst(T v) {
      if (head == null) {
        head = new LLNode<>(v);
        head = tail;
      } else {
        LLNode<T> current = new LLNode<>(v);
        current.setNxt(head);
        head = current;
      }
    }

    public void addLast(T v) {
      // If head is empty append new LLNode.
      if (tail == null) {
        head = new LLNode<T>(v);
        tail = head;
      } else {
        // Insert LLnode last
        tail.setNxt(new LLNode<>(v));
        tail = tail.getNxt();
      }
    }

    public void removeFirst() {
      if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
      }

      head = head.getNxt();
    }

    public void removeLast() {
      if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
      }

    // If only one element
    if (head.getNxt() == null) {
      head = null;
      tail = null;
      return;
    }

    LLNode<T> p = head;

    // second-to-last node
    while (p.getNxt().getNxt() != null) {
      p = p.getNxt();
    }

    // Remove the last node and update tail
    p.setNxt(null);
    tail = p;
    }

    public int getLen() {
      int cnt = 0;
      LLNode<T> p = head;

      while (p != null) {
        cnt++;
        p = p.getNxt();
      }

      return cnt;
    }

    public boolean isEmpty() {
      return head == null;
    }
    

    public LLNode<T> getList() {
      if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
      }

      return head;
    }

        @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {
        private LLNode<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          if (!hasNext()) {
            throw new IllegalStateException("No more elements");
          }

          T value = current.getVal();
          current = current.getNxt();
          
          return value;
        }
      };
    }
}
