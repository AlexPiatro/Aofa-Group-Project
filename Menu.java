import java.util.Arrays;
import java.util.Scanner;

public class GraphManager {
    private static int[][] graph;
    private static final int MAX_NODES = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        graph = new int[MAX_NODES][MAX_NODES];

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Update graph");
            System.out.println("2. Display graph");
            System.out.println("3. Max flow");
            System.out.println("4. Clear data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    updateGraph();
                    break;
                case 2:
                    displayGraph();
                    break;
                case 3:
                    maxFlow();
                    break;
                case 4:
                    clearData();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void updateGraph() {
        System.out.print("Enter the source node: ");
        int source = scanner.nextInt();
        System.out.print("Enter the destination node: ");
        int dest = scanner.nextInt();
        System.out.print("Enter the capacity: ");
        int capacity = scanner.nextInt();

        graph[source][dest] = capacity;
    }

    private static void displayGraph() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void maxFlow() {
        System.out.print("Enter the source node: ");
        int source = scanner.nextInt();
        System.out.print("Enter the sink node: ");
        int sink = scanner.nextInt();

        int maxFlow = fordFulkerson(graph, source, sink);
        System.out.println("Max flow: " + maxFlow);
    }

    private static int fordFulkerson(int[][] graph, int source, int sink) {
        int[][] residualGraph = new int[MAX_NODES][MAX_NODES];
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }

        int maxFlow = 0;
        int[] parent = new int[MAX_NODES];
        while (bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private static boolean bfs(int[][] residualGraph, int source, int sink, int[] parent
    private static boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[MAX_NODES];
        Arrays.fill(visited, false);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < MAX_NODES; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    private static void clearData() {
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                graph[i][j] = 0;
            }
        }
    }
}
