package _4_DP._3_Longest_Common_Subsequence;

/* Minimum Number of Insertion and Deletion to convert String X to String Y
   X = "helap";  len:m
   Y = "reap";   len:n
   del h and p : 2   => m - longestCommonSubsequence
   add r : 1          => n - longestCommonSubsequence

   common subsequence was : eap
   so u had to remove all other from X => (length of X - length of the longest common subsequence) removals
   now X will only have the common part
   now add the other ele's of Y which are not common to X => (length of Y - length of the longest common subsequence) insertions
 */

public class _4_NoOf_Ins_Del_X_Y {
    public static void main(String[] args) {
        String X = "helap";
        String Y = "reap";
        int m = X.length(), n = Y.length();

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        int longestCommonSubseqSize = longestCommonSubsequenceMemo(X,Y,m,n,t);

        int noOfDel = m-longestCommonSubseqSize;
        int noOfIn = n-longestCommonSubseqSize;

        System.out.println("No of Deletion: "+noOfDel);
        System.out.println("No of Insertion: "+noOfIn);
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
}

