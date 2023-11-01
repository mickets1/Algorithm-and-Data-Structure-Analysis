// Uppgift 5
public class QUnionFind extends Algorithm {
    private int[] input = null;

    public void setInput(int[] input) {
        this.input= input;
    }
    
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union (int a, int b) {
        int ra = root(a);
        int rb = root(b);
        input[ra] = rb;
    }

    public int root (int a) {
        while (a != input[a]) {
            a = input[a];
        }

        return a;
    }
}
