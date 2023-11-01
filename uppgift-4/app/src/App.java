import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uppgift1.Edge;
import uppgift1.EdgeIterator;
import uppgift1.Graph;
import uppgift1.AdjacencyIterator;
import uppgift1.DirectedGraph;
import uppgift1.UndirectedGraph;
import uppgift1.VertexIterator;
import uppgift2.BFSPath;
import uppgift2.DFSPath;
import uppgift3.DijkstraSP;
import uppgift3.HeapSort;

public class App {
    public static void main(String[] args) throws Exception {
        UndirectedGraph undirectedGraph = new UndirectedGraph(15);
          undirectedGraph.addEdge(0, 2);
          undirectedGraph.addEdge(2, 3);
          undirectedGraph.addEdge(1, 3);
          undirectedGraph.addEdge(3, 4);
          undirectedGraph.addEdge(4, 5);
          undirectedGraph.addEdge(4, 6);
          undirectedGraph.addEdge(5, 6);
          undirectedGraph.addEdge(6, 7);
          undirectedGraph.addEdge(7, 8);
          undirectedGraph.addEdge(8, 9);
          undirectedGraph.addEdge(9, 10);
          undirectedGraph.addEdge(10, 6);
          undirectedGraph.addEdge(11, 12);
          undirectedGraph.addEdge(12, 13);
          undirectedGraph.addEdge(12, 14);
          undirectedGraph.addEdge(13, 14);          

          System.out.println("Edges: " + undirectedGraph.getEdges());
          System.out.println("Vertices: " + undirectedGraph.getVertices());
          
          System.out.println("Adjacent vertices: " + undirectedGraph.adj(2));

          System.out.println("Remove edge between 0 - 2 / 2 - 0");
          undirectedGraph.removeEdge(0, 2);
          undirectedGraph.removeEdge(2, 0);
          System.out.println("Adjacent vertices: " + undirectedGraph.adj(2));

          System.out.println("is 4 adjacent to 6?: " + undirectedGraph.isAdjacent(4, 6));
          System.out.println("is 6 adjacent to 7?: " + undirectedGraph.isAdjacent(6, 7));
          System.out.println("is 9 adjacent to 6?: " + undirectedGraph.isAdjacent(9, 6));

          // Vertex Iterator:
          VertexIterator undirectedVertexIterator = new VertexIterator(undirectedGraph.adjacencyList());
          System.out.println("\nUndirected Graph vertices:");

          while (undirectedVertexIterator.hasNext()) {
            System.out.println("Vertex: " + undirectedVertexIterator.next());
          }

          // Edge iterator
          EdgeIterator undirectedEdgeIterator = new EdgeIterator(undirectedGraph.adjacencyList());
          System.out.println("\nUndirected Graph edges:");

          while (undirectedEdgeIterator.hasNext()) {
            System.out.println("Edges: " + undirectedEdgeIterator.next());
          }

          // Adjacency iterator:
          int vertex = 5;
          List<Edge> adjacencyEdges = undirectedGraph.adjacencyList().get(vertex);
          AdjacencyIterator adjacencyIterator = new AdjacencyIterator(adjacencyEdges);
          System.out.println("\nUndirected Graph Adjacency edges:");

          while (adjacencyIterator.hasNext()) {
            System.out.println("neighbours of " + vertex + ": " + adjacencyIterator.next());
          }

          System.out.println("\nDirected Graph:\n");
        DirectedGraph directedGraph = new DirectedGraph(15);
          directedGraph.addEdge(2, 0);
          directedGraph.addEdge(2, 3);
          directedGraph.addEdge(3, 1);
          directedGraph.addEdge(3, 4);
          directedGraph.addEdge(4, 3);
          directedGraph.addEdge(5, 4);
          directedGraph.addEdge(5, 6);
          directedGraph.addEdge(6, 4);
          directedGraph.addEdge(6, 10);
          directedGraph.addEdge(7, 6);
          directedGraph.addEdge(7, 8);
          directedGraph.addEdge(8, 9);
          directedGraph.addEdge(10, 9);
          directedGraph.addEdge(12, 11);
          directedGraph.addEdge(12, 13);
          directedGraph.addEdge(13, 14);
          directedGraph.addEdge(14, 12);

          System.out.println("\n" + "Directed Graph: ");
          System.out.println("Edges: " + directedGraph.getEdges());
          System.out.println("Vertices: " + directedGraph.getVertices());

          // Adjacency:
          System.out.println("is 4 adjacent to 6?: " + directedGraph.isAdjacent(2, 0));
          // No adjecency:
          System.out.println("is 6 adjacent to 7?: " + directedGraph.isAdjacent(6, 7));
          System.out.println("is 9 adjacent to 6?: " + directedGraph.isAdjacent(9, 6));

          // Vertex Iterator:
          VertexIterator dgVertexIterator = new VertexIterator(directedGraph.adjacencyList());
          System.out.println("\nUndirected Graph vertices:");

          while (dgVertexIterator.hasNext()) {
            System.out.println("Vertex: " + dgVertexIterator.next());
          }

          // Edge iterator
          EdgeIterator dgEdgeIterator = new EdgeIterator(directedGraph.adjacencyList());
          System.out.println("\nDirected Graph edges:");

          while (dgEdgeIterator.hasNext()) {
            System.out.println("Edges: " + dgEdgeIterator.next());
          }

          // Adjacency iterator:
          int vertex2 = 5;
          List<Edge> dgadjacencyEdges = directedGraph.adjacencyList().get(vertex2);
          AdjacencyIterator dgadjacencyIterator = new AdjacencyIterator(dgadjacencyEdges);
          System.out.println("\nDirected Graph Adjacency edges:");

          while (dgadjacencyIterator.hasNext()) {
            System.out.println("neighbours of " + vertex2 + ": " + dgadjacencyIterator.next());
          }
            



          // Uppgift 2: 
            // System.out.println("Undirected Graph DFS");
            // UndirectedGraph undirectedGraph = new UndirectedGraph(15);
            // undirectedGraph.addEdge(0, 2);
            // undirectedGraph.addEdge(2, 3);
            // undirectedGraph.addEdge(1, 3);
            // undirectedGraph.addEdge(3, 4);
            // undirectedGraph.addEdge(4, 5);
            // undirectedGraph.addEdge(4, 6);
            // undirectedGraph.addEdge(5, 6);
            // undirectedGraph.addEdge(6, 7);
            // undirectedGraph.addEdge(7, 8);
            // undirectedGraph.addEdge(8, 9);
            // undirectedGraph.addEdge(9, 10);
            // undirectedGraph.addEdge(10, 6);
            // undirectedGraph.addEdge(11, 12);
            // undirectedGraph.addEdge(12, 13);
            // undirectedGraph.addEdge(12, 14);
            // undirectedGraph.addEdge(13, 14);   
            // DFSPath<UndirectedGraph> dfspUd = new DFSPath<UndirectedGraph>(undirectedGraph, 3);
            // System.out.println(dfspUd.hasPathTo(5));
            // System.out.println(dfspUd.hasPathTo(11));
            // System.out.println(dfspUd.pathTo(8));


            // System.out.println("Directed Graph DFS");
            // DirectedGraph directedGraph = new DirectedGraph(15);
            // directedGraph.addEdge(2, 0);
            // directedGraph.addEdge(2, 3);
            // directedGraph.addEdge(3, 1);
            // directedGraph.addEdge(3, 4);
            // directedGraph.addEdge(4, 3);
            // directedGraph.addEdge(5, 4);
            // directedGraph.addEdge(5, 6);
            // directedGraph.addEdge(6, 4);
            // directedGraph.addEdge(6, 10);
            // directedGraph.addEdge(7, 6);
            // directedGraph.addEdge(7, 8);
            // directedGraph.addEdge(8, 9);
            // directedGraph.addEdge(10, 9);
            // directedGraph.addEdge(12, 11);
            // directedGraph.addEdge(12, 13);
            // directedGraph.addEdge(13, 14);
            // directedGraph.addEdge(14, 12);

            // DFSPath<DirectedGraph> dfspDi = new DFSPath<DirectedGraph>(directedGraph, 6);
            // System.out.println(dfspDi.hasPathTo(1));
            // System.out.println(dfspDi.hasPathTo(7));
            // System.out.println(dfspDi.pathTo(1));
            // System.out.println(dfspDi.pathTo(9));

            // System.out.println("------------------");

            // System.out.println("Undirected Graph BFS");
            // BFSPath<UndirectedGraph> bfspUd = new BFSPath<UndirectedGraph>(undirectedGraph, 3);
            // System.out.println(bfspUd.hasPathTo(5));
            // System.out.println(bfspUd.hasPathTo(11));
            // System.out.println(bfspUd.pathTo(8));

            // System.out.println("Directed Graph BFS");
            // BFSPath<DirectedGraph> bfspDi = new BFSPath<DirectedGraph>(directedGraph, 6);
            // System.out.println(bfspDi.hasPathTo(1));
            // System.out.println(bfspDi.hasPathTo(7));
            // System.out.println(bfspDi.pathTo(9));




            // Graph graph = new Graph(7);
            // graph.addEdge(0, 1, 3.0);
            // graph.addEdge(0, 2, 2.0);
            // graph.addEdge(0, 3, 4.0);
            // graph.addEdge(1, 4, 1.0);
            // graph.addEdge(2, 4, 5.0);
            // graph.addEdge(3, 5, 2.0);
            // graph.addEdge(4, 6, 4.0);
            // graph.addEdge(5, 6, 3.0);

            // int sourceV = 0;
            // DijkstraSP dijkstra = new DijkstraSP(graph, sourceV);

            // for (int v = 0; v < graph.getVertices(); v++) {
            //   System.out.println("Shortest path from " + sourceV + " to " + v + ":");
            //   System.out.println("Distance: " + dijkstra.distTo(v));
            //   System.out.println("Path: " + dijkstra.pathTo(v));
            // }



        //     String[] courses = {
        //       "1DV002;1DV001",
        //       "1DV003;1DV001",
        //       "1DV003;1DV002",
        //       "1DV004;1DV002",
        //       "1DV005;1DV003",
        //       "1DV005;1DV004",
        //       "1DV007;1DV006",
        //     };

        // int numCourses = courses.length;
        // Courses courseOrder = new Courses();
        // List<String> recCourses = courseOrder.topologicalSort(courses, numCourses);
        
        // System.out.println("Recommended course order: ");
        // for (String course : recCourses) {
        // System.out.println(course);
        // }
    }
}
