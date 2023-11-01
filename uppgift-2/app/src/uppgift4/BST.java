package uppgift4;

import java.util.ArrayList;

public class BST {
  private BTNode root;
  private int nodeCount;
    
  public BST() {
    this.root = null;
  }

  private BTNode add(BTNode n, int key) {
    // new node
    if (n == null) {
      return new BTNode(key);
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

    return n;
  }

  public void add(int key) {
    this.root = add(root, key);
  }

  private boolean contains(BTNode n, int key) {
    if (n == null) {
      return false;
    }

    if (n.getKey() > key) {
      return contains(n.getLeft(), key);
    } else if (n.getKey() < key) {
      return contains(n.getRight(), key);
    } else {
      return true;
    }
  }

  public boolean contains(int key) {
    return contains(this.root, key);
  }

  private BTNode remove(BTNode n, int key) {
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

    return n;
  }

  public void remove(int key) {
    remove(this.root, key);
  }

  private int min(BTNode n) {
    if (n.getLeft() == null) {
      return n.getKey();
    } else {
      return min(n.getLeft());
    }
  }

  private int height(BTNode n) {
    if (n == null) {
      return - 1;
    } else {
      return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }
  }

  public int height () {
    return height(this.root); // -1 not counting root
  }

  public BTNode getRoot() {
    return root;
  }

  public int getNodeCount(BTNode n) {
    if (n != null) {
      nodeCount++;
      getNodeCount(n.getLeft());
      getNodeCount(n.getRight());
    }
    return nodeCount;
  }

  public int removeKthLargest (BST bst, int k) {
    ArrayList<Integer> lst = new ArrayList<>();

    if (root == null) {
      return -1;
    }

    // Using inorder traversal to get a sorted list.
    InBSTIterator inorderBST = new InBSTIterator(bst.getRoot());

    // Handling exception from inorder
    while (inorderBST.hasNext()) {
      try {
      lst.add(inorderBST.next());
      } catch (IllegalAccessError e) {
        break;
      }
    }

    try {
    int toRemove = lst.get(lst.size() -1 - (k - 1));

    bst.remove(bst.getRoot(), toRemove).getKey();
    return toRemove;
    
  } catch (IndexOutOfBoundsException e) {
    throw new Error("No such value exists");
  }
  }
}
