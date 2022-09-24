package _4_DP.Striver_DP_Sheet._1_1D;

import java.util.Arrays;
/*
    https://www.codingninjas.com/codestudio/problems/house-robber_839733?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 */

public class _6_House_Robber_2 {
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        int[] t = new int[n];

        if(n==1)
            return valueInHouse[0];

        Arrays.fill(t,-1);
        int takingFirstEleAndNotTakingLastEle = sumNonAdj(0,valueInHouse,n-1,t);

        Arrays.fill(t,-1);
        int notTakingFirstEleAndTakingLastEle = sumNonAdj(1,valueInHouse,n,t);

        return Math.max(takingFirstEleAndNotTakingLastEle,notTakingFirstEleAndTakingLastEle);
    }

    static int sumNonAdj(int index, int[] nums, int n, int[] t){
        if(index >= n){
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        return t[index] = Math.max(nums[index]+sumNonAdj(index+2, nums, n, t),
                sumNonAdj(index+1, nums, n, t));
    }
}
