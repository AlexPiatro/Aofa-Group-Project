package Entity;
/*
Mario Cross - 1901901
Derval Reid - 2000185
Andre Grant - 1908921
Norval Excell - 1903461
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Graph {
    //The Graph is stored in the form of an adjacency matrix for which the weight are represented by integers > 0 and 0 values == there is no path.
    private int[][] adjacencyMatrix = {
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

    //Getter
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    //Setter
    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    //Update class prompts for the user to input the index of the row and column the user wishes to update
    public void UpdateGraph() {


        Scanner sc = new Scanner(System.in);

        int col;
        do {
            System.out.print("\nEnter The Column Index of The Weight To Update [0-8]: ");
            try{
                col = sc.nextInt();
                if (col == 9 || col <0){
                    System.out.print("Error: Input is Invalid!!!\n");
                }
            }catch(InputMismatchException im){
                System.out.println("Input Mismatch: Please Input an Integer.");
                sc.next();
                col = -1;
            }
        }while (col == 9 || col <0);

        int row;
        do {
            System.out.print("Enter The Row Index of The Weight To Update [0-9]: ");
            try{
                row = sc.nextInt();
                if (adjacencyMatrix[col][row] == 0){
                    System.out.print("Error. Column Input is Equal to 0\n");
                }
            }catch(InputMismatchException im){
                System.out.println("Input Mismatch: Please Input an Integer.");
                System.out.println("\n");
                sc.next();

                row = -1;
            }
        } while (adjacencyMatrix[col][row] == 0);

        int weight;

       do {
           System.out.print("Enter the new weight value: ");
           try{
               weight = sc.nextInt();
               if (weight < 0) {
                   System.out.println("Invalid input. Please enter an integer value.\n");
               }
           }catch (InputMismatchException im){
               System.out.println("Input Mismatch: Please Input an Integer!!!\n");
               sc.next();
               weight = -1;
           }
       }while (weight < 0);

       //Assign New Weight to Graph.
        adjacencyMatrix[col][row] = weight;


        System.out.println("\n");


    }

    public void DisplayGraph(){
        System.out.print("   ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.printf("%-3d", i);
        }
        System.out.println();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.printf("%-3d", i);
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.printf("%-3d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void DisplayMaxFlow(){
        MaxFlow m = new MaxFlow();
        System.out.println("The Maximum Possible Flow Is "
                + m.fordFulkerson(adjacencyMatrix));
    }
}
