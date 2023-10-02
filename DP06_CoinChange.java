//CoinChange Problem Is Based On The Concept Of Unbounded KnapSack.....

public class DP06_CoinChange {

    // To Get Total Ways Of CoinChange Using DP With Tabulation......
    public static int CoinChange_Problem(int Coins[], int Sum) { // O(n*Sum).....
        int n = Coins.length;
        int DP_Tab[][] = new int[n + 1][Sum + 1];
        // DP_Tab[i][j] --> Ways To Give (i)-Coins To Provide (j)-Sum......

        // As When Sum=0 But We Have Coins , Then There Is One Way To Give No Coins.....
        for (int i = 0; i < (n + 1); i++) { // To Initialize Col=0 With Value=1......
            DP_Tab[i][0] = 1;
        }

        // As When Coins=0 But Sum != 0 , Then There Is No Way To Give Coins.....
        for (int i = 1; i < (Sum + 1); i++) { // To Initialize Row=0 With Value=0......
            DP_Tab[0][i] = 0;
        }

        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (Sum + 1); j++) {

                // We Use (i-1) Instead Of (i) Due To Extra Row & Col Created Initially....
                int CurrCoin = Coins[i - 1]; // Value Of (i)th Item.....

                // Case-1 When The Value Of The Coin Is Less Than The Available Sum....
                if (CurrCoin <= j) {
                    // Ways = (Ways With Including CurrCoin) + (Ways With Excluding CurrCoin))
                    DP_Tab[i][j] = (DP_Tab[i][j - CurrCoin]) + (DP_Tab[i - 1][j]);

                } else {
                    // Case-2 When The Value Of The Coin Is More Than The Available Sum....
                    DP_Tab[i][j] = DP_Tab[i - 1][j]; // Simply Exclude The CurrCoin.......
                }
            }
        }
        return DP_Tab[n][Sum];
    }

    public static void main(String args[]) {
        int Coins[] = { 1, 2, 3 };
        int Sum = 4;
        int ans = CoinChange_Problem(Coins, Sum); // Ans=4....
        System.out.println("THE TOTAL WAYS TO PROVIDE SUM-(" + Sum + ") IS ::: " + ans);
    }
}
