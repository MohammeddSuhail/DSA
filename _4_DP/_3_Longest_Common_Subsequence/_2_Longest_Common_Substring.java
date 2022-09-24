package _4_DP._3_Longest_Common_Subsequence;

//foggy

public class _2_Longest_Common_Substring {
    static int max = 0;

    public static void main(String[] args) {
        String X = "abcdekfg";
        String Y = "abcscszek";
        int m = X.length(), n = Y.length();

        longestCommonSubstringRec(X, Y, m, n, 0);
        System.out.println(max);

        //bottom up
        System.out.println(longestCommonSubstringBottomUp(X, Y, m, n));
    }

    //just recursion
    static void longestCommonSubstringRec(String X, String Y, int m, int n, int c) {
        if (m == 0 || n == 0) { //if any one of string becomes null, because no further matching can be done
            max = Math.max(max,c);
            return;
        }

        //if matched then add 1 and move both m and n
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            longestCommonSubstringRec(X, Y, m - 1, n - 1, c + 1);
        else { //if not matched check if c>max and then check for other substring by moving any one string at a time
            if (c > max)
                max = c;
            c = 0;
            longestCommonSubstringRec(X, Y, m - 1, n, c);
            longestCommonSubstringRec(X, Y, m, n - 1, c);
        }
    }

    //bottom up
    static int longestCommonSubstringBottomUp(String X, String Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        int best_count = 0;

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i==0 || j==0) //initialization
                    t[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                    best_count = Math.max(t[i][j], best_count);
                } else {
                    t[i][j] = 0;
                }
            }
        }

        return best_count;
    }
}