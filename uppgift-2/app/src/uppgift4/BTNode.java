package uppgift4;

public class BTNode {
  private int key;
  private BTNode left = null;
  private BTNode right = null;
  private int dupeCount = 0;

  public BTNode (int key) {
    this.key = key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getKey() {
    return key;
  }

  public BTNode getLeft() {
    return left;
  }

  public void setLeft(BTNode left) {
    this.left = left;
  }

  public BTNode getRight() {
    return right;
  }

  public void setRight(BTNode right) {
    this.right = right;
  }

  public void setDupeCount (int inc) {
    dupeCount += inc;
  }

  public int getDupeCount () {
    return dupeCount;
  }
}
