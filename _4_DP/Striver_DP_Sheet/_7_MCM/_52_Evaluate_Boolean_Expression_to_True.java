package _4_DP.Striver_DP_Sheet._7_MCM;

/*
    https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */

public class _52_Evaluate_Boolean_Expression_to_True {
    public static int mod = 1000000007;


    /*
        Time Complexity: O(4 ^ N)
        Space Complexity: O(4 ^ N)

        Where 'N' is the the length of string.
    */
    public static int evaluateExpRec(String exp) {
        int n = exp.length();

        // We need to evaluate whole expression for true.
        return findWaysRec(exp, 0, n - 1, 1);
    }

    public static int findWaysRec(String exp, int i, int j, int isTrue) {
        // Corner Cases.
        if (i > j) {
            return 0;
        }

        // If length of expression we need to evaluate is 1.
        if (i == j) {
            if (isTrue == 1) {
                if (exp.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (exp.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }                                                         //because i+1 is a operator so left and right of operator division
                            //i=>T, i+1=>^ .... so partition from (i to k) ans (k+1 to j), where k->i+1 to j-1
        long ans = 0;       //T^F^T
        for (int k = i + 1; k <= j - 1; k += 2) {
            // The number of ways expression left to 'K' will be true.
            long leftTrue = (findWaysRec(exp, i, k - 1, 1)) % mod;

            // The number of ways expression left to 'K' will be false.
            long leftFalse = (findWaysRec(exp, i, k - 1, 0)) % mod;

            // The number of ways expression right to 'K' will be true.
            long rightTrue = (findWaysRec(exp, k + 1, j, 1)) % mod;

            // The number of ways expression right to 'K' will be false.
            long rightFalse = (findWaysRec(exp, k + 1, j, 0)) % mod;

            if (exp.charAt(k) == '|') {
                // T|T=T, T|F=T, F|T=T , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else if (exp.charAt(k) == '&') {
                // T&T=T, T&F=F, F&T=F , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                    ans = ans % mod;

                } else {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else {
                // T^T=F, T^F=T, F^T=T , F^F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
        }

        return (int)ans;
    }





    /*  Memoization
        Time Complexity: O(N ^ 3)
        Space Complexity: O(N ^ 2)

        Where 'N' is the the length of string.
     */



    public static int evaluateExp(String exp) {
        int n = exp.length();

        // We need to evaluate whole expression for true.
        memo = new long[n][n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        return findWays(exp, 0, n - 1, 1);
    }


    public static long [][][] memo;

    public static int findWays(String exp, int i, int j, int isTrue) {
        // Corner Cases.
        if (i > j) {
            return 0;
        }

        // If length of expression we need to evaluate is 1.
        if (i == j) {
            if (isTrue == 1) {
                if (exp.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (exp.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        if (memo[i][j][isTrue] != -1) {
            return (int)memo[i][j][isTrue];
        }

        long ans = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {

            if (memo[i][k - 1][1] == -1) {
                memo[i][k - 1][1] = (findWays(exp, i, k - 1, 1)) % mod;
            }

            if (memo[i][k - 1][0] == -1) {
                memo[i][k - 1][0] = (findWays(exp, i, k - 1, 0)) % mod;
            }

            if (memo[k + 1][j][1] == -1) {
                memo[k + 1][j][1] = (findWays(exp, k + 1, j, 1)) % mod;
            }

            if (memo[k + 1][j][0] == -1) {
                memo[k + 1][j][0] = (findWays(exp, k + 1, j, 0)) % mod;
            }

            // The number of ways expression left to 'K' will be true.
            long leftTrue = memo[i][k - 1][1];

            // The number of ways expression left to 'K' will be false.
            long leftFalse = memo[i][k - 1][0];

            // The number of ways expression right to 'K' will be true.
            long rightTrue = memo[k + 1][j][1];

            // The number of ways expression right to 'K' will be false.
            long rightFalse = memo[k + 1][j][0];

            if (exp.charAt(k) == '|') {
                // T|T=T, T|F=T, F|T=T , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else if (exp.charAt(k) == '&') {
                // T&T=T, T&F=F, F&T=F , F|F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                    ans = ans % mod;

                } else {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
            else {
                // T^T=F, T^F=T, F^T=T , F^F=F.
                if (isTrue == 1) {
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                    ans = ans % mod;
                } else {
                    ans += leftTrue * rightTrue + leftFalse * rightFalse;
                    ans = ans % mod;
                }
            }
        }

        memo[i][j][isTrue] = ans;
        return (int)ans;
    }
}
