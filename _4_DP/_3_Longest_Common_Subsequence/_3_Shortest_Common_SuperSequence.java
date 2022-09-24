package _4_DP._3_Longest_Common_Subsequence;

/* Shortest Common SuperSequence:
   Given string X and Y, we should merge them to get a string which contains both X and Y
   i.e, to form the shortest string which has subsequences X and Y
   e.g: X = "zeqm" , Y = "eqer"
        ans = "zeqerm" , size = 6

   The ides is, if some sequence(orderly) of ele's are common to both X an Y ,then include them only once
   i.e, ans = (m+n)-longestCommonSubsequenceSize;
   m+n will be having ele's in repeat, so remove the longestCommonSubsequence
 */

public class _3_Shortest_Common_SuperSequence {
    public static void main(String[] args) {
        String X = "zeqm";
        String Y = "eqer";
        int m = X.length(), n = Y.length();

        int[][] t=new int[m+1][n+1];
        for (int i = 0; i <m+1 ; i++)
            for (int j = 0; j <n+1 ; j++)
                t[i][j]=-1;

        int longestCommonSubseqSize = longestCommonSubsequenceMemo(X,Y,m,n,t);

        int ans = (m+n)-longestCommonSubseqSize;
        System.out.println(ans);



        //Shortest Common SuperSequence using t
        //once t is computed do this

        String s  = "";
        int i=m, j =n;
        while(i>0 && j>0){
            if(X.charAt(i-1) == Y.charAt(j-1)){
                s = Y.charAt(j-1) + s;
                i--;
                j--;
            }else if(t[i][j-1] > t[i-1][j]) {
                s = Y.charAt(j-1) + s;    //adding even if it's not equal
                j--;
            }
            else {
                s = X.charAt(i-1) + s;    //adding even if it's not equal
                i--;
            }
        }

        //only one of the below while loop wil execute, because upper loop will break when either i=0 or j=0
        //we are adding X.charAt(i-1) if i has not reached 0 yet and j has reached 0, because "ab" , "" SuperSequence of it is "ab"
        while(i>0){
            s = X.charAt(i-1) + s;    //adding even if it's not equal
            i--;
        }

        while(j>0){
            s = Y.charAt(j-1) + s;    //adding even if it's not equal
            j--;
        }

        System.out.println("Shortest Common SuperSequence: "+s);
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
