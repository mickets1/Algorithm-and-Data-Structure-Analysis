package uppgift1;

import java.util.Iterator;
import java.util.List;

public class VertexIterator implements Iterator<Integer> {
  private List<List<Edge>> vl;
  private int currentVertexIndex = 0;
  private int currentEdgeIndex = 0;

  public VertexIterator(List<List<Edge>> list){
    this.vl = list;
  }

  public VertexIterator iterator() {
    return new VertexIterator(vl);
  }

  @Override
  public boolean hasNext() {
    return currentVertexIndex < vl.size();
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      return null;
    }

    List<Edge> edges = vl.get(currentVertexIndex);

    if (currentEdgeIndex >= edges.size()) {
      currentEdgeIndex = 0;
      currentVertexIndex++;
      return next();
    }


    int nextVertex = edges.get(currentEdgeIndex).getDst();
    currentEdgeIndex++;

    return nextVertex;
  }
}