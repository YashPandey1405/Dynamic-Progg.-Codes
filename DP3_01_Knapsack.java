public class DP3_01_Knapsack {

    // To Get MaxProfit From 0-1 KnapSack Using Recursion....
    public static int KnapSack(int Value[], int Weight[], int W, int n) { // O(2^n).....
        // Base Case When The Capacity Of KnapSack=0 OR The Item Avaailable=0....
        if (W == 0 || n == 0) {
            return 0;
        }

        // Traversal Will Be Done From Last->Front Of Value & Weight Array.....
        // Case-1 When The Weight Of item Is Less Than The Available Capacity....
        if (Weight[n - 1] <= W) {
            // Case 1 :- Include The Item In MaxProfit....
            int ans1 = Value[n - 1] + KnapSack(Value, Weight, W - Weight[n - 1], n - 1);

            // Case 2 :- Exclude The Item In MaxProfit....
            int ans2 = KnapSack(Value, Weight, W, n - 1);

            return Math.max(ans1, ans2);
        } else {
            // Case-2 When The Weight Of item Is More Than The Available Capacity.....
            return KnapSack(Value, Weight, W, n - 1);
        }
    }

    // To Get MaxProfit From 0-1 KnapSack Using DP With Memoization......
    public static int KnapSack_DP_Mem(int Value[], int Weight[], int W, int n, int DP_Mem[][]) { // O(n*W).....
        // Base Case When The Capacity Of KnapSack=0 OR The Item Available=0....
        if (W == 0 || n == 0) {
            return 0;
        }
        // Case When We Already Calculated The Value Before....
        if (DP_Mem[n][W] != (-1)) {
            return DP_Mem[n][W];
        }

        // Traversal Will Be Done From Last->Front Of Value & Weight Array.....
        // Case-1 When The Weight Of item Is Less Than The Available Capacity....
        if (Weight[n - 1] <= W) {
            // Case 1 :- Include The Item In MaxProfit....
            int ans1 = Value[n - 1] + KnapSack_DP_Mem(Value, Weight, W - Weight[n - 1], n - 1, DP_Mem);

            // Case 2 :- Exclude The Item In MaxProfit....
            int ans2 = KnapSack_DP_Mem(Value, Weight, W, n - 1, DP_Mem);

            DP_Mem[n][W] = Math.max(ans1, ans2);
            return DP_Mem[n][W];
        } else {
            // Case-2 When The Weight Of item Is More Than The Available Capacity.....
            DP_Mem[n][W] = KnapSack_DP_Mem(Value, Weight, W, n - 1, DP_Mem);
            return DP_Mem[n][W];
        }
    }

    // To Get MaxProfit From 0-1 KnapSack Using DP With Tabulation......
    public static int KnapSack_DP_Tab(int Value[], int Weight[], int W) { // O(n*W).....
        int n = Value.length;
        int DP_Tab[][] = new int[n + 1][W + 1];
        for (int i = 0; i < DP_Tab.length; i++) { // To Initialize Col=0 With Value=0......
            DP_Tab[i][0] = 0;
        }
        for (int i = 0; i < DP_Tab[0].length; i++) { // To Initialize Row=0 With Value=0......
            DP_Tab[0][i] = 0;
        }
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (W + 1); j++) {

                // We Use (i-1) Instead Of (i) Due To Extra Row & Col Created With Value=0.....
                int CurrValue = Value[i - 1]; // Value Of (i)th Item.....
                int CurrWeight = Weight[i - 1]; // Weight Of (i)th Item.....

                // Case-1 When The Weight Of item Is Less Than The Available Capacity....
                if (CurrWeight <= j) {
                    // Case 1 :- Include The Item In MaxProfit....
                    int Value1 = CurrValue + DP_Tab[i - 1][j - CurrWeight];
                    // Case 2 :- Exclude The Item In MaxProfit....
                    int Value2 = DP_Tab[i - 1][j];

                    DP_Tab[i][j] = Math.max(Value1, Value2);
                } else {
                    // Case-2 When The Weight Of item Is More Than The Available Capacity.....
                    DP_Tab[i][j] = DP_Tab[i - 1][j];
                }
            }
        }
        return DP_Tab[n][W];
    }

    public static void main(String args[]) {
        int Value[] = { 15, 14, 10, 45, 30 };
        int Weight[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        // Calculation Of MaxProfit Of 0-1 KnapSack Using Recursion
        int MaxProfit1 = KnapSack(Value, Weight, W, Value.length);
        System.out.println("THE MAX PROFIT FROM 0-1 KNAPSACK WITHOUT DP IS ::: " + MaxProfit1);

        // Calculation Of MaxProfit Of 0-1 KnapSack Using DP With Memoization....
        int DP_Mem[][] = new int[Value.length + 1][W + 1];
        for (int i = 0; i < DP_Mem.length; i++) {
            for (int j = 0; j < DP_Mem[0].length; j++) {
                DP_Mem[i][j] = (-1);
            }
        }
        int MaxProfit2 = KnapSack_DP_Mem(Value, Weight, W, Value.length, DP_Mem);
        System.out.println("THE MAX PROFIT FROM 0-1 KNAPSACK WITH DP USING Memoization IS ::: " + MaxProfit2);

        // Calculation Of MaxProfit Of 0-1 KnapSack Using DP With Tabulation....
        int MaxProfit3 = KnapSack_DP_Tab(Value, Weight, W);
        System.out.println("THE MAX PROFIT FROM 0-1 KNAPSACK WITH DP USING Tabulation IS ::: " + MaxProfit3);
    }
}
