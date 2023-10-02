public class DP01_FibbonaciSeries {
    public static int Fib(int n) { // O(2^n).........
        if (n == 0 || n == 1) {
            return 1;
        }
        return Fib(n - 1) + Fib(n - 2);
    }

    // This Code Is Based On Memoization In Dynamic Programming.....
    // In Memoization Based DP , We Use Recursion To Get Answer.....
    public static int Fib_DP_Mem(int n, int DP[]) { // O(n).........
        if (n == 0 || n == 1) {
            return 1;
        }
        if (DP[n] != 0) {
            return DP[n];
        }
        DP[n] = Fib_DP_Mem(n - 1, DP) + Fib_DP_Mem(n - 2, DP);
        return DP[n];
    }

    // This Code Is Based On Tabulation In Dynamic Programming.....
    // In Tabulation Based DP , We Use Iteration To Get Answer.....
    public static int Fib_DP_Tab(int arr[]) { // O(n).....
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }

    public static void main(String args[]) {
        int n = 6;

        int ans = Fib(n);
        System.out.println("THE VALUE OF Fib(" + n + ") WITHOUT DP IS ::: " + ans);

        int DP[] = new int[n + 1]; // By Default Initialization Of Each Element Of Array By 0...
        int Ans = Fib_DP_Mem(n, DP);
        System.out.println("THE VALUE OF Fib(" + n + ") WITH DP IS ::: " + Ans);

        int arr[] = new int[n + 1]; // By Default Initialization Of Each Element Of Array By 0...
        int ANS = Fib_DP_Tab(arr);
        System.out.println("THE VALUE OF Fib(" + n + ") WITH DP IS ::: " + ANS);
    }
}