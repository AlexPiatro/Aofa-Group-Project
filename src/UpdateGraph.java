import java.util.Scanner;

public class UpdateGraph {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
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

        Scanner sc = new Scanner(System.in);

        int row;
        do {
            System.out.print("Enter the row index of the weight to update (0-8): ");
            row = sc.nextInt();
            if (row == 9){
                System.out.print("Error. Row Input is Equal to 9\n");
            }
        }while (row == 9);

        int col;
        do {
            System.out.print("Enter the column index of the weight to update (0-9): ");
            col = sc.nextInt();
            if (adjacencyMatrix[row][col] == 0){
                System.out.print("Error. Row Input is Equal to 0\n");
            }
        } while (adjacencyMatrix[row][col] == 0);

        System.out.print("Enter the new weight value: ");
        int weight = sc.nextInt();

// update weight and display updated graph
        adjacencyMatrix[row][col] = weight;
        System.out.println("Updated graph:");
        for (int[] matrix : adjacencyMatrix) {
            for (int i : matrix) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
