// Driver program to test above functions


public class Main {
    public static void main(String[] args) {
        // Let us create a graph shown in the above example
        int[][] graph = new int[][]{
                {0, 35, 21, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 24, 30, 18, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 40, 0, 0, 0},
                {0, 0, 0, 0, 0, 40, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 17, 14, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 0, 20, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 12, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 27},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        MaxFlow m = new MaxFlow();

        System.out.println("The maximum possible flow is "
                + m.fordFulkerson(graph));
    }
}