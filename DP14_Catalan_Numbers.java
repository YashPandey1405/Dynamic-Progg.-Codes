import java.util.*;

public class DP14_Catalan_Numbers {

    // Recursive Method To Evaluate Catalan(n).......
    public static int Catalan_Recursion(int n) { // O(2^n)......
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0; // This Will Store Catalan(n).....
        for (int i = 0; i <= (n - 1); i++) {
            ans += Catalan_Recursion(i) * Catalan_Recursion(n - 1 - i);
        }
        return ans;
    }

    // Memoization Method Of DP To Evaluate Catalan(n).......
    public static int Catalan_DP_Mem(int n, int DP_Mem[]) { // O(n^2)......
        if (n == 0 || n == 1) {
            return 1;
        }
        if (DP_Mem[n] != (-1)) {
            return DP_Mem[n];
        }
        int ans = 0; // This Will Store Catalan(n).....
        for (int i = 0; i <= (n - 1); i++) {
            ans += Catalan_Recursion(i) * Catalan_Recursion(n - 1 - i);
        }
        DP_Mem[n] = ans;
        return ans;
    }

    // Tabulation Method Of DP To Evaluate Catalan(n).......
    public static int Catalan_DP_Tab(int n) { // O(n^2)......
        int DP_Tab[] = new int[n + 1];
        // arr[i] --> Value Of Catalan(i).....

        // Initialization
        DP_Tab[0] = 1;
        DP_Tab[1] = 1;

        for (int i = 2; i < n + 1; i++) { // Loop To Calculate Catalan(i) One By One......
            DP_Tab[i] = 0;
            for (int j = 0; j < i; j++) {
                DP_Tab[i] += DP_Tab[j] * DP_Tab[i - 1 - j];
            }
        }
        return DP_Tab[n];
    }

    public static void main(String args[]) {
        int n = 5;

        int ans = Catalan_Recursion(n);
        System.out.println("THE VALUE OF CATALAN(" + n + ") USING RECURSION IS ::: " + ans);

        int DP_Mem[] = new int[n + 1];
        Arrays.fill(DP_Mem, -1); // Initialization By (-1).....
        int ans2 = Catalan_DP_Mem(n, DP_Mem);
        System.out.println("THE VALUE OF CATALAN(" + n + ") USING DP WITH MEMOIZATION IS ::: " + ans2);

        int ans3 = Catalan_DP_Tab(n);
        System.out.println("THE VALUE OF CATALAN(" + n + ") USING DP WITH TABULATION IS ::: " + ans3);

    }
}
