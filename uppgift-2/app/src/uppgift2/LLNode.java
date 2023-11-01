package uppgift2;

public class LLNode<T> {
    private T val;
    private LLNode<T> nxt;

    public LLNode(T v) {
      this.val = v;
    }

    public void setNxt(LLNode<T> node) {
      this.nxt = node;
    }

    public LLNode<T> getNxt() {
      return this.nxt;
    }

    public T getVal() {
      return this.val;
    }
}