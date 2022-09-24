package _4_DP.Striver_DP_Sheet._7_MCM;

/*
    https://www.codingninjas.com/codestudio/problems/maximum-subarray_3755255
 */

import java.util.Arrays;

public class _54_Partition_Array_for_Maximum_Sum {

    /*  Recursion:
        Time Complexity: O((2^N)*N).
        Space Complexity:O(N).

        where N is the size of the array and 'K' is the maximum number of elements in a subarray.
    */

    public static int maximumSubarrayRec(int num[], int k) {

        int n = num.length;

        return maxSubarrayRec(0, n, num, k);
    }

    private static int maxSubarrayRec(int index, int n, int[] num, int k) {
        // Base-case
        if (index == n) {
            return 0;
        }

        int m = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        // Iterate for every possible partition of the array
        for (int j = index; j < Math.min(index + k, n); j++) {
            m = Math.max(m, num[j]);
            // Take maximum among all partitions
            //               maxEle*size_of_partition
            ans = Math.max(ans,  m * (j - index + 1) + maxSubarrayRec(j + 1, n, num, k));
        }
        // Save the value of the current state in dp and return the ans
        return ans;
    }


    /*
        Memoization:
        Time Complexity: O(N*K).
        Space Complexity:O(N).

        where N is the size of the array and 'K' is the maximum number of elements in a subarray.
    */

    public static int maximumSubarrayMemo(int num[], int k) {
        int n = num.length;
        int[] t = new int[n];
        Arrays.fill(t,-1);

        return maxSubarrayMemo(0, n, num, k, t);
    }

    private static int maxSubarrayMemo(int index, int n, int[] num, int k, int[] t) {
        // Base-case
        if (index == n) {
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        int m = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        // Iterate for every possible partition of the array
        for (int j = index; j < Math.min(index + k, n); j++) {
            m = Math.max(m, num[j]);
            // Take maximum among all patitions
            ans = Math.max(ans, m * (j - index + 1) + maxSubarrayMemo(j + 1, n, num, k,t));
        }
        // Save the value of the current state in dp and return the ans
        return t[index] = ans;
    }
}
