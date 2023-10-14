
/*
 * In This Minimum Array Jumps Problem , We Will Be Given An Array Where We Have To Make Some Jumps.....
 * Value Of arr[i] Represents The Maximum No Of Jumps Allowed To Us....
 * We Can't Make Jumps Greater Than arr[i] But Can Make Jumps Less Than Equal To arr[i]......
 * We Will Use Dynamic Progg. Fro An Optimized Solution......
*/
import java.util.*;

public class DP21_Minimum_ArrayJumps {

    public static int MinArray_Jumps(int arr[]) { // O(n)......
        int n = arr.length;
        int DP_Tab[] = new int[n];
        // arr[i] --> Min. Jumps From arr[i]->Last Index(n-1)......

        // Initialization Step.....
        Arrays.fill(DP_Tab, (-1));
        DP_Tab[n - 1] = 0; // As , Min. Jumps From arr[n-1]->Last Index(n-1) Will Be 0......

        for (int i = (n - 2); i >= 0; i--) {
            int Steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = (i + 1); j <= (i + Steps) && j < n; j++) {
                if (DP_Tab[j] != (-1)) {
                    ans = Math.min(ans, DP_Tab[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                DP_Tab[i] = ans;
            }
        }
        return DP_Tab[0];
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 4 };
        int ans = MinArray_Jumps(arr);
        System.out.println("THE MINUMUM ARRAY JUMPS REQUIRED ARE ::: " + ans);
    }
}
