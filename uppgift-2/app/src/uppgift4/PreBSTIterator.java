package uppgift4;

import java.util.ArrayList;
import java.util.Iterator;

public class PreBSTIterator implements Iterator<Integer> {
  private ArrayList<BTNode> stack = new ArrayList<>();

  public PreBSTIterator(BTNode n) {
    push(n);
  }

  private void push(BTNode n) {
    if (n != null) {
      stack.add(n);
    } 
  }

  @Override
  public boolean hasNext() {
    return stack.size() != 0;
  }

  @Override
  public Integer next() {
    BTNode tmp;

    if (!stack.isEmpty()) {
      tmp = stack.remove(stack.size() - 1);

      if (tmp.getRight() != null) {
        push(tmp.getRight());
      }

      if (tmp.getLeft() != null) {
        push(tmp.getLeft());
      }

      return tmp.getKey();
    } else {
      throw new IllegalAccessError("***End of tree***");
    }
  }
}
