// ClimbingStairs Is Based On Fibonacci Problem....

import java.util.Arrays;

public class DP2_ClimbingStairs {

    // This Code Is Simply Using Recursion To Find The Answer.....
    public static int ClimbingStairs_Fib(int n) { // O(2^n).........
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return ClimbingStairs_Fib(n - 1) + ClimbingStairs_Fib(n - 2);
    }

    // This Code Is Based On Memoization In Dynamic Programming.....
    // In Memoization Based DP , We Use Recursion To Get Answer.....
    public static int ClimbingStairs_DP_Mem(int n, int DP_Mem[]) { // O(n).....
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (DP_Mem[n] != (-1)) {
            return DP_Mem[n];
        }
        DP_Mem[n] = ClimbingStairs_DP_Mem(n - 1, DP_Mem) + ClimbingStairs_DP_Mem(n - 2, DP_Mem);
        return DP_Mem[n];
    }

    // This Code Is Based On Tabulation In Dynamic Programming.....
    // In Tabulation Based DP , We Use Iteration To Get Answer.....
    public static int ClimbingStairs_DP_Tab(int n, int DP_Tab[]) { // O(n)......
        int m = DP_Tab.length;
        DP_Tab[0] = 1;
        DP_Tab[1] = 1;
        for (int i = 2; i < m; i++) {
            DP_Tab[i] = DP_Tab[i - 1] + DP_Tab[i - 2];
        }
        return DP_Tab[m - 1];
    }

    public static void main(String args[]) {
        int n = 6;

        int ans1 = ClimbingStairs_Fib(n);
        System.out.println("THE No OF WAYS TO CLIMB " + n + " STAIRS WITHOUT DP IS ::: " + ans1);

        int DP_Mem[] = new int[n + 1];
        Arrays.fill(DP_Mem, -1);
        int ans2 = ClimbingStairs_DP_Mem(n, DP_Mem);
        System.out.println("THE No OF WAYS TO CLIMB " + n + " STAIRS WITH Memoization BASED DP IS ::: " + ans2);

        int DP_Tab[] = new int[n + 1];
        int ans3 = ClimbingStairs_DP_Tab(n, DP_Tab);
        System.out.println("THE No OF WAYS TO CLIMB " + n + " STAIRS WITH Tabulation BASED DP IS ::: " + ans3);
    }
}
