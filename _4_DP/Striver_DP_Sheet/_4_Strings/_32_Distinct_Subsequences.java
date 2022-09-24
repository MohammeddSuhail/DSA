package _4_DP.Striver_DP_Sheet._4_Strings;

/*
    https://www.codingninjas.com/codestudio/problems/subsequence-counting_3755256?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

    Time Complexity: O(N*M)
    Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

    Space Complexity: O(N*M) + O(N+M)
    Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
 */

public class _32_Distinct_Subsequences {
    static int modlo = (int)(Math.pow(10,9)+7);
    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        // Write your code here..
        int m = lt, n = ls;

        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                dp[i][j]=-1;

        return longestCommonSubsequenceMemo(t,s,lt,ls,dp);
    }

    static int longestCommonSubsequenceMemo(String X, String Y, int m, int n,int[][] t) {
        if(n==0) //matched all chars of second string
            return 1;

        if(m==0)  //i,e, n!=0 but m=0, that means all char of X is finished but no complete match with Y
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        //if matched then move both m and n or just move m(that is not considering cur match of char
        //and finding char of Y other index of X)
        if(X.charAt(m-1) == Y.charAt(n-1))
            return t[m][n] = (longestCommonSubsequenceMemo(X,Y,m-1,n-1,t) +
                    longestCommonSubsequenceMemo(X,Y,m-1,n,t))%modlo;
        else //move any one of them and see which is max
            return t[m][n] = longestCommonSubsequenceMemo(X,Y,m-1,n,t)%modlo;
    }
}
