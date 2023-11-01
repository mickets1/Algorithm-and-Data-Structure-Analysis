package uppgift4;

public class AVLNode {
  private int key;
  private int height = 0;
  private AVLNode left = null;
  private AVLNode right = null;
  private int dupeCount = 0;


  public AVLNode (int key) {
    this.key = key;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getKey() {
    return key;
  }

  public AVLNode getLeft() {
    return left;
  }

  public void setLeft(AVLNode left) {
    this.left = left;
  }

  public AVLNode getRight() {
    return right;
  }

  public void setRight(AVLNode right) {
    this.right = right;
  }

  public void setDupeCount (int inc) {
    dupeCount += inc;
  }

  public int getDupeCount () {
    return dupeCount;
  }
}
