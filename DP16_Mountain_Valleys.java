// In Mountain Valleys Problem , We Return Total No Of Valleys Possible For Pair Of [/,\].......
// This Problem Is Based On The Concept Of Catalan Number.....

public class DP16_Mountain_Valleys {

    public static int Mountain_Valleys(int n) { // O(n^2).......
        int DP_Tab[] = new int[n + 1];
        // arr[i] --> Total Mountain-Valleys For (i)-Pair Of [/,\].....

        // Initialization Step
        DP_Tab[0] = 1; // Total Mountain-Valleys For n=0 Will Be 1 (NULL).........
        DP_Tab[1] = 1; // Total Mountain-Valleys For n=1 Will Be 1 (Only One /\).........

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int InSide = DP_Tab[j];
                int OutSide = DP_Tab[i - 1 - j];
                DP_Tab[i] += (InSide * OutSide);
            }
        }

        return DP_Tab[n];
    }

    public static void main(String args[]) {
        int n = 5; // n-Pairs Of [/,\]......
        int ans = Mountain_Valleys(n);
        System.out.println("THE TOTAL MOUNTAIN VALLEYS FORM (" + n + ")-PAIRS IS ::: " + ans);
    }

}
