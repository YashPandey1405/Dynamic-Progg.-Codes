/*
 * In Edit Distance Problem , We Will Be Given 2 String str1 & str2 , We Have To Find Minimum Number
   Of Operations Required To Convert String 'str1' --> String 'str2'.....
 * The 3 Operations Permitted To Be Applied On A Word Are : -
        --> Insert A Character In String 'str1'......
        --> Delete A Character From String 'str1'......
        --> Replace A Character In String 'str1'......
*/

public class DP11_EditDistanceProblem {

    // In This Function , We Will Edit Distance Value Using DP With Tabulation......
    public static int EditDistance_DP_Tab(String str1, String str2) { // O(m*n)....
        int m = str1.length();
        int n = str2.length();
        int DP_Tab[][] = new int[m + 1][n + 1];
        // arr[i][j] -->No Of Changes Requied To Convert First [0,i] Char Of 'str1'
        // To First [0,j] Char Of String 'str2'.....

        // Edits Required To Convert (0)-Len 'str1' To (j)-Len'str2' Will Be (j).....
        // Edits Required To Convert (i)-Len 'str1' To (0)-Len'str2' Will Be (i).....
        for (int i = 0; i < (m + 1); i++) {
            for (int j = 0; j < (n + 1); j++) {
                if (i == 0) { // To Initialize Row=0 With Edits=Len Of 'str2' i.e (j)......
                    DP_Tab[i][j] = j;
                }
                if (j == 0) { // To Initialize Col=0 With Edits=Len Of 'str1' i.e (i)......
                    DP_Tab[i][j] = i;
                }
            }
        }

        for (int i = 1; i < (m + 1); i++) {
            for (int j = 1; j < (n + 1); j++) {
                char c1 = str1.charAt(i - 1); // Last Character Of String 'str1'....
                char c2 = str2.charAt(j - 1); // Last Character Of String 'str2'....

                if (c1 == c2) { // When Last Char Of Both String Is Same....
                    DP_Tab[i][j] = DP_Tab[i - 1][j - 1];
                } else {
                    // Case 1 --> Addition Of Char To String 'str1'......
                    int Val1 = DP_Tab[i][j - 1] + 1;
                    // Case 2 --> Deletion Of Char From String 'str1'......
                    int Val2 = DP_Tab[i - 1][j] + 1;
                    // Case 1 --> Replace Of Char In String 'str1'......
                    int Val3 = DP_Tab[i - 1][j - 1] + 1;
                    DP_Tab[i][j] = Math.min(Val1, Math.min(Val2, Val3));
                }
            }
        }
        return DP_Tab[m][n];
    }

    public static void main(String args[]) {
        String str1 = "intention";
        String str2 = "execution";
        int ans = EditDistance_DP_Tab(str1, str2);
        System.out.println("MINIMUM EDITS TO CONVERT '" + str1 + "' TO '" + str2 + "' IS ::: " + ans);
    }
}
