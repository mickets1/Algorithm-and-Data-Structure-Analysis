package uppgift2;


import java.util.ArrayList;
import java.util.List;

import uppgift1.Graph;

public class BFSPath<T> {
  private ArrayList<Boolean> marked;
  private ArrayList<Integer> edgeTo;
  private Graph graph;
  private int node;

  public BFSPath(Graph g, int node) {
    this.graph = g;
    this.node = node;
    
    int sz = g.getVertices();

    this.marked = new ArrayList<Boolean>(sz);
      for(int i = 0; i < sz; i++)  {
        this.marked.add(Boolean.FALSE);
      }

    this.edgeTo = new ArrayList<Integer>(sz);
      for(int i = 0; i < sz; i++)  {
        this.edgeTo.add(-1);
      }

    bfs(node);
  }

  // Breadth First Search.
  private void bfs(int node) {
  ArrayList<Integer> queue = new ArrayList<Integer>();
    queue.add(node);
    marked.set(node, true);

    int queueIndex = 0; // front of queue.

    while (queueIndex < queue.size()) {
        int lNode = queue.get(queueIndex);
        queueIndex++;

        List<Integer> adj = graph.adj(lNode);
        for (int n : adj) {
            if (!marked.get(n)) {
              queue.add(n); // add to end of queue.
              marked.set(n, true);
              edgeTo.set(n, lNode);
            }
        }
    }
  }

  public boolean hasPathTo(int node) {
    return marked.get(node);
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
}
