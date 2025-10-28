import java.util.*;

// 1️ Efficient Traveler
class EfficientTraveler extends ArrayHandler {
    private int initialEnergy;

    private void setEnergy() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial energy: ");
        initialEnergy = sc.nextInt();
    }

    @Override
    public void solve() {
        setEnergy();
        int energy = initialEnergy;
        int count=0;
        int cost;
        for (int i = 1; i < n; i++) {
             cost=nums[i-1];
            if (energy -cost>= 0) {
                energy=energy -cost;
            count++;
            }else{
                break;
            }
        }
          System.out.println("Farthest City Index: " + count);

    }
}

// 2️ The Sum That Stands Out
class SumThatStandsOut extends ArrayHandler {
    @Override
public void solve() {
    // Step 1: Create prefix and postfix sum arrays
    int[] preSum = new int[n];
    int[] postSum = new int[n];

    // Step 2: Compute prefix sum (from left to right)
    preSum[0] = 0;  // no elements before index 0
    for (int i = 1; i < n; i++) {
        preSum[i] = preSum[i - 1] + nums[i - 1];
    }

    // Step 3: Compute postfix sum (from right to left)
    postSum[n - 1] = 0;  // no elements after last index
    for (int i = n - 2; i >= 0; i--) {
        postSum[i] = postSum[i + 1] + nums[i + 1];
    }

    // Step 4: Compare prefix and postfix sums
    int result = -1;
    for (int i = 0; i < n; i++) {
        if (preSum[i] == postSum[i]) {
            result = i;
            break;
        }
    }

    // Step 5: Display result
    System.out.println("Equilibrium Index: " + result);
}

}

// 3️ Flip the Switch
class FlipTheSwitch extends ArrayHandler {
    @Override
    public void solve() {
        int count0 = 0, count1 = 0;
        for (int x : nums) {
            if (x == 0) count0++;
            else count1++;
        }
        System.out.println("Minimum Flips: " + Math.min(count0, count1));
    }
}


// 4️ Odd One Out (2D array version)
class OddOneOut extends ArrayHandler {
    @Override
    public void solve() {
        // Step 1: Create a 2D array to store [number, frequency]
        int[][] freqArr = new int[n][2];

        // Step 2: Initialize numbers and their frequencies
        for (int i = 0; i < n; i++) {
            freqArr[i][0] = nums[i];  // store number
            freqArr[i][1] = 0;        // initialize frequency
        }

        // Step 3: Count frequencies
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < n; j++) {
                if (freqArr[j][0] == num) {
                    freqArr[j][1]++;  // increment count
                }
            }
        }

        // Step 4: Find number with frequency 1
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (freqArr[i][1] == 1) {
                result = freqArr[i][0];
                break;
            }
        }

        // Step 5: Display result
        System.out.println("Odd One Out: " + result);
    }
}


// 5️⃣ Smart Pair Finder
class SmartPairFinder extends ArrayHandler {
    @Override
    public void solve() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target value (k): ");
        int k = sc.nextInt();

        // Step 1: Sort the array first (required for two-pointer approach)
        Arrays.sort(nums);

        // Step 2: Initialize pointers and pair counter
        int i = 0;
        int j = n - 1;
        int count = 0;

        // Step 3: Search for pairs that sum to k
        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum > k) {
                j--;     // reduce sum
            } else {
                i++;     // increase sum
            }
        }

        // Step 4: Display the result
        if (count > 0)
            System.out.println("Pair Exists: True (" + count + " pair(s) found)");
        else
            System.out.println("Pair Exists: False");
    }
}


// 6️ Minimalist Painter
class MinimalistPainter extends ArrayHandler {
    @Override
    public void solve() {
        int total = 0, max = 0;
        for (int x : nums) {
            total += x;
            if (x > max) max = x;
        }
        System.out.println("Minimum Time After Skip: " + (total - max));
    }
}
