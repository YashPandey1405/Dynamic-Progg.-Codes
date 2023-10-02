public class DP05_Unbounded_KnapSack {
    // To Get MaxProfit From Unbounded KnapSack Using DP With Tabulation......
    public static int UnBounded_KnapSack_DP_Tab(int Value[], int Weight[], int W) { // O(n*W).....
        int n = Value.length;
        int DP_Tab[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) { // To Initialize Col=0 With Value=0......
            DP_Tab[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) { // To Initialize Row=0 With Value=0......
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
                    int Value1 = CurrValue + DP_Tab[i][j - CurrWeight];
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
        int ans = UnBounded_KnapSack_DP_Tab(Value, Weight, W);
        System.out.println("THE MAX PROFIT IN THE UNBOUNDED KNAPSACK IS ::: " + ans);
    }

}