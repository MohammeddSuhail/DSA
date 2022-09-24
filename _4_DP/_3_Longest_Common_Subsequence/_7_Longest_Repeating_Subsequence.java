package _4_DP._3_Longest_Common_Subsequence;

/*
    Longest repeating subsequence:
    We will be given X, we have to find The Longest repeating subsequence

    idea is that : LCS(X,X) with a constraint that X.charAt(i-1) == Y.charAt(j-1) && i!=j
    i!=j, because we are trying to find same ele when index are not same,so that way we will know they are more than 1 occurrence of that ele
 */

public class _7_Longest_Repeating_Subsequence {
    public static void main(String[] args) {
        String X = "albacdbekcfg";
        String Y = X;
        int m = X.length(), n = Y.length();

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        System.out.println(longestCommonSubsequenceMemo(X,Y,m,n,t));
    }

    static int longestCommonSubsequenceMemo(String X, String Y, int m, int n,int[][] t) {
        if(m==0 || n==0) //if any one of string becomes null, because no further matching can be done
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        //if matched then move both m and n
        if(X.charAt(m-1) == Y.charAt(n-1) && m!=n)  // m!=n, because we are trying to find same ele when index are not same
            return t[m][n] = 1+longestCommonSubsequenceMemo(X,Y,m-1,n-1,t);
        else //move any one of them and see which is max
            return t[m][n] = Math.max(longestCommonSubsequenceMemo(X,Y,m-1,n,t), longestCommonSubsequenceMemo(X,Y,m,n-1,t));
    }

}
