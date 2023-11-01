package uppgift1;

public class LLNode {
    private int val;
    private LLNode nxt;

    public LLNode(int v) {
      this.val = v;
    }

    public void setNxt(LLNode node) {
      this.nxt = node;
    }

    public LLNode getNxt() {
      return this.nxt;
    }

    public int getVal() {
      return this.val;
    }
}
