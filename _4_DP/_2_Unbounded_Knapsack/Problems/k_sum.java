package _4_DP._2_Unbounded_Knapsack.Problems;

/*
    https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=1
 */

import java.util.Arrays;

public class k_sum {
    public static int minimumElementsRec(int num[], int x) {
        // Write your code here..
        int ans = unboundKnapRec(0,x,num);

        if(ans == Math.pow(10,9))
            return -1;
        else
            return ans;
    }

    static int unboundKnapRec(int index, int sum, int[] nums){
        if(sum == 0)
            return 0;

        if(index == nums.length)
            return (int)Math.pow(10,9);

        if(nums[index] <= sum)
            return Math.min(1+ unboundKnapRec(index,sum-nums[index],nums),
                    unboundKnapRec(index+1,sum,nums));
        else
            return unboundKnapRec(index+1,sum,nums);
    }








    //memo
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        int[][] t = new int[n][x+1];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);

        int ans = unboundKnap(0,x,num,t);

        if(ans == Math.pow(10,9))
            return -1;
        else
            return ans;
    }

    static int unboundKnap(int index, int sum, int[] nums, int[][] t){
        if(sum == 0)
            return 0;

        if(index == nums.length)
            return (int)Math.pow(10,9);

        if(t[index][sum] != -1)
            return t[index][sum];

        if(nums[index] <= sum)
            return t[index][sum] =Math.min(1+unboundKnap(index,sum-nums[index],nums,t),
                    unboundKnap(index+1,sum,nums,t));
        else
            return t[index][sum] = unboundKnap(index+1,sum,nums,t);
    }

}

