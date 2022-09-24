package _4_DP._3_Longest_Common_Subsequence;

/*
        Sequence Pattern Matching: If String X in Y
        e.g:
        X = "axy";
        Y = "adxcpy"
        ans: true

        Idea is that:
        Find LCS and if LCS size = length of X, then X is present in Y

        can be also solved using a single loop

 */


public class _8_Is_X_In_Y_Sequence_Pattern_Matching {
    public static void main(String[] args) {
        String X = "axy";
        String Y = "adxcpy";
        int m = X.length(), n = Y.length();

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        int longestCommonSubseqSize = longestCommonSubsequenceMemo(X,Y,m,n,t);

        System.out.print("Is X a subsequence of Y: ");
        if(longestCommonSubseqSize == m)
            System.out.println("True");
        else
            System.out.println("False");

        System.out.println("Is X a subsequence of Y(using a single loop): "+isSubsequence(X,Y,m,n));
    }

    static int longestCommonSubsequenceMemo(String X, String Y, int m, int n,int[][] t) {
        if(m==0 || n==0) //if any one of string becomes null, because no further matching can be done
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        //if matched then move both m and n
        if(X.charAt(m-1) == Y.charAt(n-1))
            return t[m][n] = 1+longestCommonSubsequenceMemo(X,Y,m-1,n-1,t);
        else //move any one of them and see which is max
            return t[m][n] = Math.max(longestCommonSubsequenceMemo(X,Y,m-1,n,t), longestCommonSubsequenceMemo(X,Y,m,n-1,t));
    }

    static boolean isSubsequence(String X, String Y, int m, int n) {
        int i = 0;

        for (int j = 0;  j<n ; j++) {
            if(Y.charAt(j) == X.charAt(i))
                i++;
        }
        return i == m;
    }
}
