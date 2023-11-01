package uppgift3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uppgift1.Edge;
import uppgift1.Graph;

public class DijkstraSP {
  private ArrayList<Edge> edgeTo;
  private ArrayList<Double> distTo;

  public DijkstraSP(Graph g, int s) {
    int numVertices = g.getVertices();
    edgeTo = new ArrayList<>(numVertices);
    distTo = new ArrayList<>(numVertices);
    
    for (int i = 0; i < numVertices; i++) {
      edgeTo.add(null);
      distTo.add(Double.POSITIVE_INFINITY);
    }

    distTo.set(s, 0.0);
    HeapSort h = new HeapSort();
    h.heapPush(s);

    while (h.getHeapSize() > 0) {
      int v = h.heapPop();

      for (Integer w : g.adj(v)) {
        double weight = findEdgeWeight(g.adjacencyList(), v, w);
        relax(v, w, weight);
        h.heapPush(w);
      }
    }
  }

  public void relax(int v, int w, double weight) {
    double newDist = distTo.get(v) + weight;
    if (newDist < distTo.get(w)) {
      distTo.set(w, newDist);
      edgeTo.set(w, new Edge(v, w, weight));
    }
  }

  private double findEdgeWeight(List<List<Edge>> adjacencyList, int v, int w) {
    for (Edge edge : adjacencyList.get(v)) {
      if (edge.getDst() == w) {
        return edge.getWeight();
      }
    }
    return Double.POSITIVE_INFINITY;
  }

  public List<Edge> pathTo(int v) {
    ArrayList<Edge> path = new ArrayList<>();
    Edge edge = edgeTo.get(v);
    while (edge != null) {
      path.add(edge);
      edge = edgeTo.get(edge.getSrc());
    }
    Collections.reverse(path);
    return path;
  }

  public double distTo(int v) {
    return distTo.get(v);
  }
}
