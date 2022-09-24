package _4_DP.Striver_DP_Sheet._4_Strings;

/*
    https://www.codingninjas.com/codestudio/problems/edit-distance_630420?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

    Time Complexity: O(N*M)
    Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

    Space Complexity: O(N*M) + O(N+M)
    Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
 */

public class _33_Edit_Distance {
    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int m = str1.length(), n = str2.length();

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        return longestCommonSubsequenceMemo(str1,str2,m,n,t);
    }

    static int longestCommonSubsequenceMemo(String X, String Y, int m, int n,int[][] t) {
        if(m==0)  //remaining n elements to be deleted from Y
            return n;
        if(n==0)
            return m; //remining m elements to be added to Y

        if(t[m][n] != -1)
            return t[m][n];

        //if matched then move both m and n, then no swap,insert,delete required
        if(X.charAt(m-1) == Y.charAt(n-1))
            return t[m][n] = 0 + longestCommonSubsequenceMemo(X,Y,m-1,n-1,t);
        else //replace or delete or insert required
            return t[m][n] = 1+ Math.min(longestCommonSubsequenceMemo(X,Y,m-1,n-1,t),
                    Math.min(longestCommonSubsequenceMemo(X,Y,m-1,n,t),
                            longestCommonSubsequenceMemo(X,Y,m,n-1,t)));
    }
}
