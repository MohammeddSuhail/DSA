package _4_DP._3_Longest_Common_Subsequence.Palindrome;

/* same as Minimum number of deletion in a string to make it a palindrome

   Minimum number of insertions in a string to make it a palindrome
   We will be only given X , we have to find Minimum number of insertion in X to make it a palindrome

   idea is that: find the Longest Palindromic Subsequence (LPS = LCS(X,reverse(X)))
                 once we get it, we add all other ele which are not present in LCS
                 ans = (m - LPS) number of insertions

   e.g:
   X: aebcbda
   Y: adbcbea
   Minimum number of insertion in a string to make it a palindrome: 2             //i.e, (e and d) must be inserted
 */

public class _9_Min_NoOf_ins_X_to_palin {
    public static void main(String[] args) {
        String X = "aebcbda";
        int m = X.length();

        String Y = "";

        for (int i = m-1; i >=0; i--)
            Y += X.charAt(i);

        int n = Y.length(); //will be same as length of X

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        int longestCommonSubseqSize = longestCommonSubsequenceMemo(X,Y,m,n,t);

        int minIns = m -longestCommonSubseqSize;

        System.out.println("X: "+X);
        System.out.println("Y: "+Y);
        System.out.println("Minimum number of insertion in a string to make it a palindrome: "+ minIns);
    }

    static int longestCommonSubsequenceMemo(String X, String Y, int m, int n, int[][] t) {
        if(m == 0 || n == 0){
            return 0;
        }

        if(t[m][n] != -1)
            return t[m][n];

        if(X.charAt(m-1) == Y.charAt(n-1))
            return t[m][n] = 1 + longestCommonSubsequenceMemo(X,Y,m-1,n-1,t);
        else
            return t[m][n] = Math.max(longestCommonSubsequenceMemo(X,Y,m-1,n,t) , longestCommonSubsequenceMemo(X,Y,m,n-1,t));
    }
}
