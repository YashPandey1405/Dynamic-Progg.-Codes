//Rod Cutting Problem Is Based On The Concept Of Unbounded KnapSack.....

public class DP07_RodCutting {

    // To Get Total Ways Of Rod Cutting Using DP With Tabulation......
    public static int RodCutting_Problem(int Peices[], int Value[], int TotalLength) { // O(n*TotalLength).....
        int n = Peices.length;
        int DP_Tab[][] = new int[n + 1][TotalLength + 1];
        // DP_Tab[i][j]--> Profit When (i)-Peices are Joined To Form (j)-Length Rod.....

        // As When TotalLength=0 But We Have Peices , Then There Is No Way
        // To Combine Peices To Make 0-Length Rod.....
        for (int i = 0; i < (n + 1); i++) { // To Initialize Col=0 With Value=0......
            DP_Tab[i][0] = 0;
        }

        // As When Peices=0 But TotalLength != 0 , Then There Is No Way To Make Rod.....
        for (int i = 1; i < (TotalLength + 1); i++) { // To Initialize Row=0 With Value=0......
            DP_Tab[0][i] = 0;
        }

        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (TotalLength + 1); j++) {

                // We Use (i-1) Instead Of (i) Due To Extra Row & Col Created Initially....
                int CurrLength = Peices[i - 1]; // Length Of (i)th Peice.....
                int CurrValue = Value[i - 1]; // Value Of (i)th Peice.....

                // Case-1 --> When The Length Of Peice Is Less Than The Available Length....
                if (CurrLength <= j) {
                    int Val1 = CurrValue + (DP_Tab[i][j - CurrLength]); // Profit By Including CurrLength.....
                    int Val2 = (DP_Tab[i - 1][j]); // Profit By Excluding CurrLength.....
                    DP_Tab[i][j] = Math.max(Val1, Val2);

                } else {
                    // Case-2 --> When The Length Of Peice Is More Than The Available Length....
                    DP_Tab[i][j] = DP_Tab[i - 1][j]; // Simply Exclude The CurrLength.......
                }
            }
        }
        return DP_Tab[n][TotalLength];
    }

    public static void main(String args[]) {
        int Peices[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int Value[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int TotalLength = 8;
        int ans = RodCutting_Problem(Peices, Value, TotalLength);
        System.out.println("THE MAX PROFIT FROM THE ROD OF LENGTH-(" + TotalLength + ") IS ::: " + ans);
    }

}
