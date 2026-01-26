import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProblemSolver problem = null;

        System.out.println("===== WEEK 1 OOP PROBLEMS (Java Version) =====");

        while (true) {
            System.out.println("\nChoose a problem to run:");
            System.out.println("1. Efficient Traveler");
            System.out.println("2. The Sum That Stands Out");
            System.out.println("3. Flip The Switch");
            System.out.println("4. Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. Minimalist Painter");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> problem = new EfficientTraveler();
                case 2 -> problem = new SumThatStandsOut();
                case 3 -> problem = new FlipTheSwitch();
                case 4 -> problem = new OddOneOut();
                case 5 -> problem = new SmartPairFinder();
                case 6 -> problem = new MinimalistPainter();
                case 0 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice! Try again.");
                    continue;
                }
            }

            problem.inputArray();
            problem.solve();  // polymorphic call
        }
    }
}

