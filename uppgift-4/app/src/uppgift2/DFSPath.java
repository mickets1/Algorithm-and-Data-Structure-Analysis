package uppgift2;

import java.util.ArrayList;

import uppgift1.Graph;

public class DFSPath<T> {
  private ArrayList<Boolean> marked;
  private ArrayList<Integer> edgeTo;
  private Graph graph;
  private int node;
  
  public DFSPath(Graph g, int node) {
    this.graph = g;
    this.node = node;
    
    int sz = g.getVertices();

    this.marked = new ArrayList<Boolean>(sz);
      for(int i = 0; i < sz; i++)  {
        this.marked.add(Boolean.FALSE);
      }

    this.edgeTo = new ArrayList<Integer>(sz);
      for(int i = 0; i < sz; i++)  {
        this.edgeTo.add(0);
      }

    dfs(node);
  }

  // Depth First Search.
  private void dfs(int node) {
    marked.set(node, true);

    for (Integer w : graph.adj(node)) {
      if (!marked.get(w)) {
        dfs(w);
        this.edgeTo.set(w, node);
      }
    }
  }

  public ArrayList<Integer> pathTo(int node) {
    if (!hasPathTo(node)) {
      return null;
    }

    int x = node;
    ArrayList<Integer> path = new ArrayList<Integer>();

    while (x != this.node) {
      path.add(0, x);
      x = this.edgeTo.get(x);
    }

    path.add(0, this.node);
    return path;
  }

  public boolean hasPathTo(int node) {
    return marked.get(node);
  }
}
