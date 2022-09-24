package _4_DP.Striver_DP_Sheet._6_LIS;

import java.util.Arrays;

public class _41_Longest_Increasing_Subsequence {
    /*
        Just Recursion:
        Time complexity: 2^n
        Space complexity: n
    */
    public static int longestIncreasingSubsequenceRec(int[] arr) {
        return subSeqRec(0, arr, -1);
    }

    static int subSeqRec(int index, int arr[], int prev){
        if(index == arr.length)
            return 0;

        if(prev == -1 || arr[prev] < arr[index]){//take or not take
            return Math.max(1 + subSeqRec(index+1,arr,index),
                    subSeqRec(index+1,arr,prev));
        }
        else
            return subSeqRec(index+1,arr,prev);
    }



    /*
        Memoization:
        Time Complexity: O(N*N)
        Reason: There are N*N states therefore at max ‘N*N’ new problems will be solved.

        Space Complexity: O(N*N) + O(N)
        Reason: We are using an auxiliary recursion stack space(O(N)) (see the recursive tree,
        in the worst case we will go till N calls at a time) and a 2D array ( O(N*N+1)).
     */

    public static int longestIncreasingSubsequenceMemo(int[] arr) {
        int n = arr.length;
        int[][] t = new int[n][n+1];  //[index][prev seen index], n+1 because prev na
                                      //prev is from -1 to n-1, so do 1 to n, i.e, prev+1
                                      //i.e, storing prev in prev+1
        for(int[] row: t)
            Arrays.fill(row,-1);

        return subSeqMemo(0, arr, -1,t);
    }

    static int subSeqMemo(int index, int[] arr, int prev, int[][] t){
        if(index == arr.length)
            return 0;

        if(t[index][prev+1] != -1)
            return t[index][prev+1];


        if(prev == -1 || arr[prev] < arr[index]){//tale or not take
            return t[index][prev+1] = Math.max(1 + subSeqMemo(index+1,arr,index,t),
                    subSeqMemo(index+1,arr,prev,t));
        }
        else
            return t[index][prev+1] = subSeqMemo(index+1,arr,prev,t);
    }
}
