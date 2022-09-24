package _4_DP._1_0_1Knapsack.Types_Of_Probs;


class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;

        return signChangeSumK(nums,n,0,target);
    }

    int signChangeSumK(int[] nums, int n, int sum, int target){
        if(n == 0 && sum == target)
            return 1;

        if(n==0){  //if all ele is considered but sum!=target
            return 0;
        }
        // (taking +ve sign) + (taking -ve sign)
        return signChangeSumK(nums,n-1,sum + nums[n-1],target) + signChangeSumK(nums,n-1,sum-nums[n-1],target);
    }
}
