package uppgift4;

import java.util.ArrayList;
import java.util.Iterator;

public class InBSTIterator implements Iterator<Integer> {
  private ArrayList<BTNode> stack = new ArrayList<>();
  private BTNode n;

  public InBSTIterator(BTNode n) {
    this.n = n;
    pushLC(n);
  }

  private void pushLC(BTNode n) {
    while(n != null) {
      stack.add(n);
      n = n.getLeft();
    }
  }

  @Override
  public boolean hasNext() {
    return n != null;
  }

  @Override
  public Integer next() {
    BTNode tmp;

    if (!stack.isEmpty()) {
      tmp = stack.remove(stack.size() - 1);

      if (tmp.getRight() != null) {
        pushLC(tmp.getRight());
      }

      return tmp.getKey();
    } else {
      throw new IllegalAccessError("***End of tree***");
    }
  }
}

