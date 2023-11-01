package uppgift1;

// Uppgift 1
public class LinkedList {
    private LLNode head;
    private LLNode tail;

    public LinkedList () {
      head = null;
      tail = null;
    }

    public void append (int v) {
        // If head is empty append new LLNode.
        if (head == null) {
          head = new LLNode(v);
          tail = head;
        } else {
          // Insert LLnode last
          tail.setNxt(new LLNode(v));
          tail = tail.getNxt();
        }
    }

    public boolean isEmpty() {
      return head == null;
    }

    public int getLen() {
      int cnt = 0;
      LLNode p = head;

      while (p != null) {
        cnt++;
        p = p.getNxt();
      }

      return cnt;
    }

    public void delete(int v) {
      // Delete if only one LLNode.
      if (head != null) {
        if (head.getVal() == v) {
          if (head.getNxt() == null) {
            head = null;
          } else {
            // Point to next LLNode
            head = head.getNxt();
          }
        } else {
          LLNode p = head;
          
          while (p.getNxt() != null && p.getNxt().getVal() != v) {
            p = p.getNxt();
          }

          if (p.getNxt() != null) {
            p.setNxt(p.getNxt().getNxt());
          }

          // update tail to element before last.
          tail = p;
        }
      }
    }

    // Reverse the Linked list.
    public LLNode reverseLL() {
      LLNode prev = null;
      LLNode current = head;
      LLNode next = null;

      while (current != null) {
        // save tmp next.
        next = current.getNxt();
        // set next of current to previous.
        current.setNxt(prev);
        prev = current;
        current = next;
      }
      head = prev;
      
      return head;
    }

    public LLNode getList() {
      return head;
    }
}