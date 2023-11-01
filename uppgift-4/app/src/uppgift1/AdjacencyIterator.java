package uppgift1;

import java.util.Iterator;
import java.util.List;

public class AdjacencyIterator implements Iterator<Integer> {
  private List<Edge> edges;
  private int currentIndex = 0;

  public AdjacencyIterator(List<Edge> adjacencyEdges) {
    this.edges = adjacencyEdges;
  }

  @Override
  public boolean hasNext() {
    return currentIndex < edges.size();
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      return null;
    }

    int next = edges.get(currentIndex).getDst();
    currentIndex++;

    return next;
    }
  }