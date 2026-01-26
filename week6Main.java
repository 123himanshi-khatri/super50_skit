// @filename - Main.java
// @description - Menu-driven program for Week 6 Story
// @author - Himanshi

import java.util.*;

public class week6Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            try {
                System.out.println("\n--- WEEK 6 ASSIGNMENT ---");
                System.out.println("1. Minimum Time to Complete All Tasks");
                System.out.println("2. Dijkstra Using Adjacency Matrix");
                System.out.println("3. Detect Cycle in Directed Graph");
                System.out.println("4. Minimum Cost Path in Grid");
                System.out.println("5. Strongly Connected Components Count");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();

                switch(ch) {

                    case 1:
                        System.out.print("Enter number of tasks: ");
                        int n = sc.nextInt();
                        int time[] = new int[n];

                        for(int i = 0;i < n;i++)
                            time[i] = sc.nextInt();

                        System.out.print("Enter number of dependencies: ");
                        int e = sc.nextInt();
                        int edges[][] = new int[e][2];

                        for(int i = 0;i < e;i++) {
                            edges[i][0] = sc.nextInt();
                            edges[i][1] = sc.nextInt();
                        }

                        System.out.println("Minimum Time = " +
                            Method.minTimeTasks(time, edges, n));
                        break;

                    case 2:
                        System.out.print("Enter vertices: ");
                        int v = sc.nextInt();
                        int mat[][] = new int[v][v];

                        for(int i = 0;i < v;i++)
                            for(int j = 0;j < v;j++)
                                mat[i][j] = sc.nextInt();

                        System.out.print("Enter source: ");
                        int src = sc.nextInt();

                        System.out.println(Arrays.toString(
                            Method.dijkstraMatrix(mat, src)));
                        break;

                    case 3:
                        System.out.print("Enter nodes: ");
                        int nn = sc.nextInt();
                        System.out.print("Enter edges: ");
                        int ee = sc.nextInt();

                        int ed[][] = new int[ee][2];
                        for(int i = 0;i < ee;i++) {
                            ed[i][0] = sc.nextInt();
                            ed[i][1] = sc.nextInt();
                        }

                        System.out.println(Method.hasCycle(nn, ed));
                        break;

                    case 4:
                        System.out.print("Rows: ");
                        int r = sc.nextInt();
                        System.out.print("Cols: ");
                        int c = sc.nextInt();

                        int grid[][] = new int[r][c];
                        for(int i = 0;i < r;i++)
                            for(int j = 0;j < c;j++)
                                grid[i][j] = sc.nextInt();

                        System.out.println("Minimum Cost = " +
                            Method.minCostGrid(grid));
                        break;

                    case 5:
                        System.out.print("Enter nodes: ");
                        int sn = sc.nextInt();
                        System.out.print("Enter edges: ");
                        int se = sc.nextInt();

                        int sed[][] = new int[se][2];
                        for(int i = 0;i < se;i++) {
                            sed[i][0] = sc.nextInt();
                            sed[i][1] = sc.nextInt();
                        }

                        System.out.println("SCC Count = " +
                            Method.countSCC(sn, sed));
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch(Exception ex) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}
