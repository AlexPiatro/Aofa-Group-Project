package View;// Driver program to test above functions
/*
Mario Cross - 1901901
Derval Reid - 2000185
Andre Grant - 1908921
Norval Excell - 1903461
*/

import Entity.MaxFlow;
import Entity.Graph;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ScheduledFuture;

public class Main {
    public static void main(String[] args) {

        //Create instance of Scanner Class
        Scanner scan = new Scanner(System.in);

        Graph grp = new Graph();
        char choice;

        //create a case structure
        do{
            int ch;
            System.out.println("\nSelect An Operation From The List Below:\n");
            System.out.println("1. Display Graph: ");
            System.out.println("2. Update Graph: ");
            System.out.println("3. Display Max Flow: ");
            System.out.println("4. Exit ");

            do {
                try {
                    ch = scan.nextInt();
                    if (ch > 4){
                        System.out.print("Error: Input Out of Bounds!!!\n");
                        System.out.println("1. Display Graph: ");
                        System.out.println("2. Update Graph: ");
                        System.out.println("3. Display Max Flow: ");
                        System.out.println("4. Exit ");
                    }
                }catch (InputMismatchException im){
                    System.out.println("Input Mismatch: Please Input an Integer.");
                    scan.next();
                    ch = -1;
                }
            }while (ch > 4 || ch < 0);


            switch (ch) {
                case 1 ->
                    //Displays The Adjacency Matrix of the graph with Labelled Vertices.
                        grp.DisplayGraph();
                case 2 -> {
                    char Sch = 'Y';
                    while (Sch == 'Y' || Sch == 'y') {
                        grp.DisplayGraph();
                        grp.UpdateGraph();

                        System.out.println("Updated Graph:");
                        grp.DisplayGraph();

                        System.out.println("\nDo You Want To Update Another Weight? Enter 'Y' or 'N':\n");
                        Sch = scan.next().charAt(0);
                    }
                }
                case 3 -> grp.DisplayMaxFlow();
                case 4 -> {
                    System.out.println("Program Terminated.....");
                    System.exit(0);
                }
            }
            System.out.println("\nDo you want to Continue 'Y' or 'y'\n");
            System.out.println("Or Press and Key to Terminate\n");
            choice = scan.next().charAt(0);
        }while (choice == 'Y' || choice == 'y');
    }
}