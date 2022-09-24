package _4_DP.Striver_DP_Sheet._1_1D;

/*
    https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

    Using Recursion:
    Time Complexity: O(2^N)

    Using Memoization:
    Time Complexity: O(N)
    Reason: The overlapping sub-problems will return the answer in constant time O(1).
    Therefore, the total number of new sub-problems we solve is ‘n’. Hence, total time complexity is O(N).

    Space Complexity: O(N)
    Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class _5_Maximum_sum_of_non_adjacent_elements {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.

        //recursion
        int ansUsingRec =  sumNonAdjRec(0,nums,nums.size());

        //memoization
        int[] t = new int[nums.size()];
        Arrays.fill(t,-1);
        int ansUsingMemo = sumNonAdjMemo(0,nums,nums.size(),t);

        return ansUsingRec; //return ansUsingMemo;
    }

    //just recursion
    static int sumNonAdjRec(int index, ArrayList<Integer> nums, int n){
        if(index == n){
            return 0;
        }

        if(index>n)
            return 0;

        return Math.max(nums.get(index)+ sumNonAdjRec(index+2, nums, n), sumNonAdjRec(index+1, nums, n));
    }

    //memoization
    static int sumNonAdjMemo(int index, ArrayList<Integer> nums, int n, int[] t){
        if(index >= n){
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        return t[index] = Math.max(nums.get(index)+ sumNonAdjMemo(index+2, nums, n, t), sumNonAdjMemo(index+1, nums, n, t));
    }
}
