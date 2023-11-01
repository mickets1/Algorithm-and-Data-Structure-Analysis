package uppgift1;

import java.util.List;

public class DirectedGraph extends Graph {
  public DirectedGraph(int sz) {
    // Parent constructor call to create a new Arraylist
    super(sz);
  }

  public int getEdges() {
    int sum = 0;
    for (int i = 0; i < this.al.size(); i++) {
        sum += al.get(i).size();
    }

    return sum;
  }

  public void addEdge(int src, int dst) {
    addEdge(src, dst, 1.0);
  }

  public void addEdge(int src, int dst, double weight) {
    if (src < al.size() && dst < al.size()) {
      al.get(src).add(new Edge(src, dst, weight));
    }
  }

  public boolean isAdjacent(int src, int dst) {
    List<Edge> srcEdges = al.get(src);
    for (Edge edge : srcEdges) {
        if (edge.getDst() == dst) {
            return true;
        }
    }
    return false;
}

}
