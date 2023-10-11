// In Counting BST Problem , We Retun Total No Of BST Possible For Given Nodes/Elements In Array.......
// This Problem Is Based On The Concept Of Catalan Number.....

public class DP15_Count_BST {

    public static int Count_BST(int n) { // O(n^2).......
        int DP_Tab[] = new int[n + 1];
        // arr[i] --> Total BST Possible For n=i.....

        // Initialization Step
        DP_Tab[0] = 1; // Total BST For n=0 Will Be 1 Only(NULL).........
        DP_Tab[1] = 1; // Total BST For n=1 Will Be 1 Only(Root Node Only).........

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int LeftCount = DP_Tab[j];
                int RightCount = DP_Tab[i - 1 - j];
                DP_Tab[i] += (LeftCount * RightCount);
            }
        }

        return DP_Tab[n];
    }

    public static void main(String args[]) {
        int n = 4; // Let --> {10,20,30}
        int ans = Count_BST(n);
        System.out.println("THE TOTAL WAYS TO FORM BST WITH (" + n + ")-NODES IS ::: " + ans);
    }

}