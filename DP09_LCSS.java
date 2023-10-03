//LCSS -> Lowest Common SubString Between 2 Strings.....
//A Substring Is A Contigious Sequence Of Characters Within A String...... 

public class DP09_LCSS {
    // In This Function, We Will Find LCSS With DP Using Tabulation......
    public static int LCSS_DP_Tab(String str1, String str2) { // O(m*n).....
        int m = str1.length();
        int n = str2.length();
        int ans = 0;
        int DP_Tab[][] = new int[m + 1][n + 1];
        // DP_Tab[i][j] --> LCSS Value For [0,i] Char->'str1' & [0,j] Char->'str2'......

        // When Either Length Of 'str1' OR 'str2' Is 0 , Then , LCSS=0.....
        for (int i = 0; i < (m + 1); i++) { // Initialize Col=0 With Value=0......
            DP_Tab[i][0] = 0;
        }
        for (int i = 0; i < (n + 1); i++) { // Initialize Row=0 With Value=0......
            DP_Tab[0][i] = 0;
        }

        for (int i = 1; i < (m + 1); i++) {
            for (int j = 1; j < (n + 1); j++) {
                char c1 = str1.charAt(i - 1); // Last Character Of String 'str1'....
                char c2 = str2.charAt(j - 1); // Last Character Of String 'str2'....
                if (c1 == c2) { // When Last Char Of Both String Is Same.....
                    DP_Tab[i][j] = DP_Tab[i - 1][j - 1] + 1;
                    ans = Math.max(ans, DP_Tab[i][j]);
                } else {
                    // When c1!=c2 , SubString Cond. Will Fail -> Counter Will Restart From 0....
                    DP_Tab[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        int ANS = LCSS_DP_Tab(str1, str2);
        System.out.println("THE LCSS VALUE FOR STRING '" + str1 + "' & '" + str2 + "' IS ::: " + ANS);
    }
}