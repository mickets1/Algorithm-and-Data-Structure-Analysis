package uppgift4;

import java.util.ArrayList;
import java.util.Iterator;

public class PostOrderIterator implements Iterator<Integer> {
  private ArrayList<BTNode> reversedStack = new ArrayList<>();
  private ArrayList<BTNode> stack = new ArrayList<>();

  public PostOrderIterator(BTNode n) {
    push(n);
  }

  private void push(BTNode n) {
    if (n != null) {
      reversedStack.add(0, n);
    }

    while (!reversedStack.isEmpty()) {
      BTNode tmp;

      if (!reversedStack.isEmpty()) {
        tmp = reversedStack.remove(0);

      if (tmp.getLeft() != null) {
          push(tmp.getLeft());
      }

      if (tmp.getRight() != null) {
          push(tmp.getRight());
      }

        stack.add(n);
      }
    }
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public Integer next() {
    return stack.remove(0).getKey();
  }
}
