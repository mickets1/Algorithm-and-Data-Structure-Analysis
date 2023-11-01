// Uppgift 6
public class WQUnionFind extends Algorithm {
    int[] range = null;
    int[] sz = null;

    public void setInput(int[] input, int[] arr) {
        this.range = input;
        this.sz = arr;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int ra = root(a);
        int rb = root(b);

        if (sz[ra] < sz[rb]) {
            range[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            range[rb] = ra;
            sz[ra] += sz[rb];
        }
    }

    public int root(int a) {
        while (a != range[a]) {
            a = range[a];
        }

        return a;
    }
}
