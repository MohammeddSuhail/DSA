package _4_DP._3_Longest_Common_Subsequence;

//In t
//x-axis: 1st string ele from 1 to m
//y-axis: 2nd string ele from 1 to n

/*
       criteria for matching:
       1. Input: Two strings X and Y
       2. Sequence
       3. Output: int
       if any 2 matches possibility of the question can be done using LCS
 */

public class _1_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String X = "abcdekfg";
        String Y = "acszekg";
        int m = X.length(), n = Y.length();

        System.out.println(longestCommonSubsequence(X,Y,m,n));


        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        System.out.println(longestCommonSubsequenceMemo(X,Y,m,n,t));

        //bottom up
        System.out.println(longestCommonSubsequenceBottomUp(X,Y,m,n));


        //print the longest substring using t
        //once t is computed do this

        String s  = "";
        int i=m, j =n;
        while(i>0 && j>0){
            if(X.charAt(i-1) == Y.charAt(j-1)){
                s = Y.charAt(j-1) + s;
                i--;
                j--;
            }else{
                if(t[i][j-1] > t[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        System.out.println("Longest substring: "+s);


        //not working for one ele
        int  index = m-1;
        String ans = "";

        for(j=1;j<n+1;j++){
            if(t[index][j] > t[index][j-1])
                ans += Y.charAt(j-1);
        }

        System.out.println("Longest substring: "+ans);
    }

    static int longestCommonSubsequence(String X, String Y, int m, int n) {
        if(m==0 || n==0) //if any one of string becomes null, because no further matching can be done
            return 0;

        //if matched then move both m and n
        if(X.charAt(m-1) == Y.charAt(n-1))
            return 1+longestCommonSubsequence(X,Y,m-1,n-1);
        else //move any one of them and see which is max
            return Math.max(longestCommonSubsequence(X,Y,m-1,n), longestCommonSubsequence(X,Y,m,n-1));
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

    //bottom up

    static int longestCommonSubsequenceBottomUp(String X, String Y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j == 0)
                    t[i][j] = 0;
                else if(X.charAt(i-1) == Y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
            }
        }

        return t[m][n];
    }
}
