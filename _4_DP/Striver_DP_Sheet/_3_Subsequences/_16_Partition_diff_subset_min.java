package _4_DP.Striver_DP_Sheet._3_Subsequences;

import java.util.Arrays;

//was not successful

public class _16_Partition_diff_subset_min {
    static int[][] t = null;
    public static void main(String[] args) {
        int[] arr = {8,6,5};
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        t = new int[n][sum+1];
        for(int i=0;i<n;i++)
            for (int j = 0; j < sum+1; j++)
                t[i][j] = -1;

        //fill t
        System.out.println(isThereEleSumMemoization(arr,sum,arr.length-1));

        /*
            now last row of t will say whether we can make subset of sum 0,1,.....,sum
            if yes, then other subset sum will be sum-j, j is 0,1,.....,sum
            so u can find difference between them
         */

        for (int[] row : t) {
            System.out.println(Arrays.toString(row));
        }
        for(int i=0;i<n;i++){
            for (int j = 0; j < sum+1; j++){
                if(t[i][j] == 1){
                    System.out.println(i +" "+j);
                }
            }
        }

//        diff logic
//        int min = Integer.MAX_VALUE;
//        for (int j = 0; j <=sum ; j++) {
//            if(t[n-1][j] == 1){
//                int otherSubsetSum = sum - j;
//                min = Math.min(min, Math.abs(j-otherSubsetSum));
//            }
//        }
//
//        System.out.println(min);
    }

    static boolean isThereEleSumMemoization(int[] arr,int sum,int n) {
        if (sum == 0)
            return true;

        if (n < 0) {
            return false;
        }

        if (t[n][sum] != -1) {
            if (t[n][sum] == 1)
                return true;
            else
                return false;
        }

        boolean res;
        if (arr[n] <= sum)
            res = (isThereEleSumMemoization(arr, sum - arr[n], n - 1) || isThereEleSumMemoization(arr, sum, n - 1));
        else
            res = isThereEleSumMemoization(arr, sum, n - 1);

        if (res == true)
            t[n][sum] = 1;
        else
            t[n][sum] = 0;
        return res;
    }
}
