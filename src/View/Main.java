package View;// Driver program to test above functions


import Entity.MaxFlow;
import Entity.Graph;

public class Main {
    public static void main(String[] args) {
       // MaxFlow m = new MaxFlow();
        Graph g = new Graph();
        g.UpdateGraph();

        //System.out.println("The maximum possible flow is "
              // + m.fordFulkerson(g.getAdjacencyMatrix()));
    }
}