//We Will Find Target Sum In Subset Of A Given Array Using DP With Tabulation Method.....

public class DP4_TargetSum {
    // Time Complexity Of This Method Is O(n * TargetSum)......
    public static boolean TargetSum_DP_Tab(int arr[], int TargetSum) {
        int n = arr.length;
        boolean DP_Tab[][] = new boolean[n + 1][TargetSum + 1];
        for (int i = 0; i < DP_Tab.length; i++) {
            DP_Tab[i][0] = true;
        }
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (TargetSum + 1); j++) {
                // We Use (i-1) Instead Of (i) Due To Extra Row Initialized with False.....
                int Value = arr[i - 1];
                // Case 1 --> Include The Current Value.....
                if (Value <= j && DP_Tab[i - 1][j - Value] == true) {
                    DP_Tab[i][j] = true;
                }
                // Case 2 --> Exclude The Current Value.....
                else if (DP_Tab[i - 1][j] == true) {
                    DP_Tab[i][j] = true;
                }
            }
        }
        return DP_Tab[n][TargetSum];
    }

    public static void main(String args[]) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int TargetSum = 10;
        System.out.println(
                "TARGET = " + TargetSum + " PRESENT IN THE GIVEN ARRAY ::: " + TargetSum_DP_Tab(arr, TargetSum));
    }
}
