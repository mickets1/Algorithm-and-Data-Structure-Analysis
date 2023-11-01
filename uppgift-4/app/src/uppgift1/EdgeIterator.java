package uppgift1;

import java.util.Iterator;
import java.util.List;

public class EdgeIterator implements Iterator<Edge> {
    private List<List<Edge>> al;
    private int currentVertexIndex = 0;
    private int currentEdgeIndex = 0;

    public EdgeIterator(List<List<Edge>> adjacencyList) {
        this.al = adjacencyList;
    }

    @Override
    public boolean hasNext() {
        while (currentVertexIndex < al.size() && currentEdgeIndex >= al.get(currentVertexIndex).size()) {
            currentVertexIndex++;
            currentEdgeIndex = 0;
        }
        return currentVertexIndex < al.size();
    }

    @Override
    public Edge next() {
        if (!hasNext()) {
            return null;
        }
        List<Edge> edges = al.get(currentVertexIndex);
        Edge nextEdge = edges.get(currentEdgeIndex);
        currentEdgeIndex++;
        return nextEdge;
    }
}
