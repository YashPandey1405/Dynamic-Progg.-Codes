public class DP13_WildCard_Matching {

    public static boolean IsMatch(String str1, String str2) { // O(m*n).....
        int m = str1.length();
        int n = str2.length();
        boolean DP_Tab[][] = new boolean[m + 1][n + 1]; // By Default Initialization By False.....
        // arr[i][j]--> bool value For i-Len 'str1' & j-Len 'str2'......

        // Initialization Step....

        // When Both String Are Empty , Then Both Will Be Same......
        DP_Tab[0][0] = true;

        // When Pattern 'str2' Are Empty=" " , Then Both Willn't Be Same......
        for (int i = 1; i < m + 1; i++) {
            DP_Tab[i][0] = false;
        }

        // When String 'str1' Are Empty=" " , Then , If Char=* , Then It Depends On
        // Prev. Value......
        for (int j = 1; j < n + 1; j++) {
            char Last = str2.charAt(j - 1);
            if (Last == '*') {
                DP_Tab[0][j] = DP_Tab[0][j - 1];
            }
            // For Other Values Of Row=0 , Value=False.....
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2 || c2 == '?') {
                    DP_Tab[i][j] = DP_Tab[i - 1][j - 1];
                } else if (c2 == '*') {
                    boolean Val1 = DP_Tab[i - 1][j];
                    boolean Val2 = DP_Tab[i][j - 1];
                    DP_Tab[i][j] = Val1 || Val2;
                } else {
                    DP_Tab[i][j] = false;
                }
            }
        }
        return DP_Tab[m][n];
    }

    public static void main(String args[]) {
        String str1 = "baaabab";
        String str2 = "*****ba*****ab";
        boolean ans = IsMatch(str1, str2);
        System.out.println("THE MATCH RESULT IS ::: " + ans);
    }
}