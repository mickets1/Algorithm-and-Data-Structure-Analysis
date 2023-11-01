package uppgift1;

import java.util.List;

public class UndirectedGraph extends Graph {
  public UndirectedGraph(int sz) {
    // Parent constructor call to create a new Arraylist
    super(sz);
  }

 public void addEdge(int v, int w) {
      addEdge(v, w, 1.0); // Default weight is 1.0
    }

    public void addEdge(int v, int w, double weight) {
      if (v < al.size() && w < al.size()) {
        al.get(v).add(new Edge(v, w, weight));
        al.get(w).add(new Edge(w, v, weight));
      }
    }

  // Iterating through all edges
  public void removeEdge(int v, int w) {
   // Get adjacency list of vertices
    if (v < al.size() && w < al.size()) {
      List<Edge> vEdges = al.get(v);
      List<Edge> wEdges = al.get(w);

      // If edge connects to vertex v, remove from w
      for (int i = 0; i < wEdges.size(); i++) {
        if (wEdges.get(i).getSrc() == v) {
          wEdges.remove(i);
          break;
        }
      }
      
      // If edge connects to vertex w, remove from v
      for (int i = 0; i < vEdges.size(); i++) {
        if (vEdges.get(i).getDst() == w) {
          vEdges.remove(i);
          break;
        }
      }
    }
  }

  public boolean isAdjacent(int v, int w) {
    List<Edge> v1Edges = al.get(v);
    for (Edge edge : v1Edges) {
        if (edge.getDst() == w) {
            return true;
        }
    }
    return false;
}

  public int getEdges() {
    int sum = 0;
    for (int i = 0; i < al.size(); i++) {
      sum += al.get(i).size();
    }

    return sum / 2;
  }
}
