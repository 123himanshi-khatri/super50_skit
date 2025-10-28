import java.util.*;

// Base class for all problems (handles array input/output)
public abstract class ArrayHandler extends ProblemSolver {
    protected int[] nums;
    protected int n;

    // Encapsulation — array details are private to this class
    public void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        n = sc.nextInt();
        nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
    }

    public void display() {
        System.out.print("Array: ");
        for (int i : nums) System.out.print(i + " ");
        System.out.println();
    }
}
