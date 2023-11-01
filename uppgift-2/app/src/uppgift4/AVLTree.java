package uppgift4;

public class AVLTree {
  private AVLNode root;
  private int nodeCount = 0;

  public AVLTree() {
    this.root = null;
  }

  public void add(int key) {
    this.root = add(root, key);
  }

  private AVLNode add(AVLNode n, int key) {
    // new node
    if (n == null) {
      return new AVLNode(key);
    }

    if (n.getKey() > key) {
      n.setLeft(add(n.getLeft(), key));
    } else if (n.getKey() < key) {
      n.setRight(add(n.getRight(), key));
    } else {
      // Increment key count if duplicate
      // if (key == n.getKey()) {
      //   n.setDupeCount(1);
      //   return n;
      // }
    }

    return balance(n);
  }

  private AVLNode balance(AVLNode n) {
    if (n == null) {
      return n;
    }

    if (height(n.getLeft()) - height(n.getRight()) > 1) {
      if (height(n.getLeft().getLeft()) >= height(n.getLeft().getRight())) {
        n = rotateLeft(n);
      } else {
        n = doubleLeft(n);
      }
      
    } else if (height(n.getRight()) - height(n.getLeft()) > 1) {
      if (height(n.getRight().getRight()) >= height(n.getRight().getLeft())) {
        n = rotateRight(n);
       } else {
        n = doubleRight(n);
      }
    }

    n.setHeight(Math.max(height(n.getLeft()), height(n.getRight())) + 1);
    return n;
  }

  private AVLNode doubleLeft(AVLNode n) {
    n.setLeft(rotateRight(n.getLeft()));
    return rotateLeft(n);
  }

  private AVLNode doubleRight(AVLNode n) {
    n.setRight(rotateLeft(n.getRight()));
    return rotateRight(n);
  }

  private AVLNode rotateRight(AVLNode r2n) {
    AVLNode r1n = r2n.getRight();
    r2n.setRight(r1n.getLeft());
    r1n.setLeft(r2n);

    r2n.setHeight(Math.max(height(r2n.getLeft()), height(r2n.getRight())) + 1);
    r1n.setHeight(Math.max(height(r1n.getLeft()), r2n.getHeight()) + 1);

    return r1n;
  }

  private AVLNode rotateLeft(AVLNode r2n) {
    AVLNode r1n = r2n.getLeft();
    r2n.setLeft(r1n.getRight());
    r1n.setRight(r2n);

    r2n.setHeight(Math.max(height(r2n.getLeft()), height(r2n.getRight())) + 1);
    r1n.setHeight(Math.max(height(r1n.getLeft()), r2n.getHeight()) + 1);

    return r1n;
  }

  private AVLNode remove(AVLNode n, int key) {
    if (n == null) {
      return null;
    }

    if (n.getKey() > key) {
      n.setLeft(remove(n.getLeft(), key));
    } else if (n.getKey() < key) {
      n.setRight(remove(n.getRight(), key));
    } else {
      // Decrease dupe count and return null
      // if (n.getDupeCount() > 1) {
      //   n.setDupeCount(-1);
      //   return null;
      // }

      if (n.getRight() == null) {
        return n.getLeft();
      }

      if (n.getLeft() == null) {
        return n.getRight();
      }

      n.setKey(min(n.getRight()));
      n.setRight(remove(n.getRight(), key));
    }

    return balance(n);
  }

  public void remove(int key) {
    remove(this.root, key);
  }

  private int min(AVLNode n) {
    if (n.getLeft() == null) {
      return n.getKey();
    } else {
      return min(n.getLeft());
    }
  }

  public int height () {
    return height(this.root);
  }

  private int height (AVLNode n) {
    if (n == null) {
      return -1;
    }
    return n.getHeight();
  }

  public int getNodeCount(AVLNode n) {
    if (n != null) {
      nodeCount++;
      getNodeCount(n.getLeft());
      getNodeCount(n.getRight());
    }
    return nodeCount;
  }

  public AVLNode getRoot() {
    return this.root;
  }

  public void printInorder(AVLNode n) {
    if (n != null) {
      printInorder(n.getLeft());
      System.out.println(n.getKey());
      printInorder(n.getRight());
    }
  }

  public void printPreOrder(AVLNode n) {
    if (n != null) {
      System.out.println(n.getKey());
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
    }
  }
}
