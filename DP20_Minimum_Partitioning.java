public class DP20_Minimum_Partitioning {

    // Function To Calculate The Sum Of All Elements Of The Array.....
    public static int Cal_Sum(int arr[]) {
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int Minimum_Partitioning(int arr[]) {
        int n = arr.length;
        int TotalSum = Cal_Sum(arr);
        int W = TotalSum / 2;

        int DP_Tab[][] = new int[n + 1][W + 1];
        // arr[i][j] --> Value Of Sum From (i)-Elements & (j)-Target.....

        // Initialization Step....
        for (int i = 0; i < n; i++) {
            DP_Tab[i][0] = 0;
            DP_Tab[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int Val1 = arr[i - 1]; // (-1) Due To Extra Row.....
                int Val2 = j;

                if (Val1 <= Val2) { // Valid Condition......

                    int Value1 = arr[i - 1] + DP_Tab[i - 1][j - arr[i - 1]]; // Include Curr Value.....
                    int Value2 = DP_Tab[i - 1][j]; // Exclude Curr Value.....

                    DP_Tab[i][j] = Math.max(Value1, Value2);
                } else {
                    DP_Tab[i][j] = DP_Tab[i - 1][j]; // Exclude Curr Value.....
                }
            }
        }
        int Sum1 = DP_Tab[n][W];
        int Sum2 = TotalSum - Sum1;
        return Math.abs(Sum1 - Sum2);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 6, 11, 5 };
        int ans = Minimum_Partitioning(arr);
        if (ans == 0) {
            System.out.println("THE VALUE OF PARTITIONING IS ::: " + ans);
            System.out.println("WE CAN MAKE PARTITION IN 2 EQUAL SETS......");
        } else {
            System.out.println("THE VALUE OF PARTITIONING IS ::: " + ans);
            System.out.println("WE CAN'T MAKE PARTITION IN 2 EQUAL SETS......");
        }
        // System.out.println("YASH Pandey");
    }
}