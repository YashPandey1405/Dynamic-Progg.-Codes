//LIS --> Longest Increasing SubSequence For An Array.....

import java.util.*;

public class DP10_LIS {
    public static int LCS(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int DP_Tab[][] = new int[m + 1][n + 1];
        // LCS Value Will Be 0 When No Of Elements In 'arr1' OR 'arr2' Is 0.....
        for (int i = 0; i < m + 1; i++) { // To Initialize Col=0 With LCS Value=0......
            DP_Tab[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) { // To Initialize Row=0 With LCS Value=0......
            DP_Tab[0][i] = 0;
        }
        for (int i = 1; i < (m + 1); i++) {
            for (int j = 1; j < (n + 1); j++) {
                int Num1 = arr1[i - 1]; // Last Value Of Array arr1.....
                int Num2 = arr2[j - 1]; // Last Value Of Array arr2.....
                if (Num1 == Num2) { // When Last Value Of Both Array Is Same.....
                    DP_Tab[i][j] = DP_Tab[i - 1][j - 1] + 1;
                } else {
                    int Val1 = DP_Tab[i - 1][j];
                    int Val2 = DP_Tab[i][j - 1];
                    DP_Tab[i][j] = Math.max(Val1, Val2);
                }
            }
        }
        return DP_Tab[m][n];
    }

    public static int LIS_DP_Tab(int arr1[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        int arr2[] = new int[hs.size()];
        int idx = 0;
        for (int i : hs) {
            arr2[idx] = i;
            idx++;
        }
        Arrays.sort(arr2);
        return LCS(arr1, arr2);
    }

    public static void main(String args[]) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        int ans = LIS_DP_Tab(arr);
        System.out.println("THE VALUE OF LIS FOR GIVEN ARRAY IS ::: " + ans);
    }
}
