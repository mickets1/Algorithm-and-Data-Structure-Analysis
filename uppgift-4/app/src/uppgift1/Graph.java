package uppgift1;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  protected List<List<Edge>> al;

  public Graph(int sz) {
    this.al = new ArrayList<>(sz);

    for(int i = 0; i < sz; i++)  {
      al.add(new ArrayList<>());
    }
  }

  public Graph() {
  }

  public void addEdge(int v, int w) {
    addEdge(v, w, 1.0);
  }

  public void addEdge(int v, int w, double weight) {
    if (v < al.size() && w < al.size()) {
        al.get(v).add(new Edge(v, w, weight));
      }
    }

  public List<Integer> adj(int v) {
    List<Integer> adjVertices = new ArrayList<>();
    if (v < al.size()) {
      for (Edge edge : al.get(v)) {
        adjVertices.add(edge.getDst());
      }
    }

    return adjVertices;
}

  public int getVertices() {
    return al.size();
  }

    public List<List<Edge>> adjacencyList() {
      return this.al;
    }
}
