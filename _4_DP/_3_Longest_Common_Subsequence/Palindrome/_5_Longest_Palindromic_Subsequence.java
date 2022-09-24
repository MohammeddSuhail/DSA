package _4_DP._3_Longest_Common_Subsequence.Palindrome;

/* Longest Palindromic Subsequence of String X
   we have to find The Longest Palindromic Subsequence of x

   The idea: we can get this by finding the longest Common Subsequence Size between X and reverse(X)
   ans = LCS(X,reverse(X))
   so here Y will be reverse of X

   eg:
   X: zabrwbxaw
   Y: waxbwrbaz   (reverse of X)
   The Longest Palindromic Subsequence: 5    ,i.e, abrba
 */

public class _5_Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String X = "zabrwbxaw";
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

        System.out.println("X: "+X);
        System.out.println("Y: "+Y);
        System.out.println("Longest Palindromic Subsequence: "+ longestCommonSubseqSize);
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
