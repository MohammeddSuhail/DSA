package _4_DP.Striver_DP_Sheet._4_Strings;

/*
    https://www.codingninjas.com/codestudio/problems/wildcard-pattern-matching_701650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

    Time Complexity: O(N*M)
    Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

    Space Complexity: O(N*M) + O(N+M)

 */

import java.util.Arrays;

public class _34_Wildcard_Pattern_Matching {
    public static boolean wildcardMatching(String pattern, String text) {

        int n = pattern.length();
        int m = text.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);
        return wildcardMatchingUtil(pattern, text, n - 1, m - 1, dp) == 1;

    }

    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }

    static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {

        //Base Conditions
        if (i < 0 && j < 0) //if both properly matched
            return 1;
        if (i < 0 && j >= 0) //if not matched
            return 0;
        if (j < 0 && i >= 0) //if remaining chars of Pattern are * then matched
            return isAllStars(S1, i) ? 1 : 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')//both matched or ? so move on in both
            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);
        else { //* mean 0 or more char match
            if (S1.charAt(i) == '*') //0 match(just move i) or more match(just move j, to keep matching with*)
                return (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 ||
                        wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
            else
                return 0;
        }
    }
}
