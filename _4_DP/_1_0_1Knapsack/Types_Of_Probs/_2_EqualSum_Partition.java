package _4_DP._1_0_1Knapsack.Types_Of_Probs;

//first subset sum and second subset sum must be same, let's say 's' is the subset sum
//s+s=>2s, i.e, even . that means equal sum partition can only be done if the sum of whole array is even, if odd partition can't be done
//so if we find out if sum/2 ele subset is present then it obviously means the rest of the ele's add up to sum/2
//so just check if subset with summation sum/2 exist.

/*
    Time Complexity: O(N*K)
    Reason: There are N*K states therefore at max ‘N*K’ new problems will be solved.
    K is target sum

    Space Complexity: O(N*K) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
 */

public class _2_EqualSum_Partition {
    public static void main(String[] args) {
        int[] arr = {5,12,2,5};
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int[][] t = new int[n+1][(sum/2)+1];
        for(int i=0;i<n+1;i++)
            for (int j = 0; j < (sum/2)+1; j++)
                t[i][j] = -1;

        if(sum%2 != 0)
            System.out.println("false");
        else
            System.out.println(subSetSumK(arr,n,sum/2,t));
    }

    static boolean subSetSumK(int[] arr, int n, int sum,int[][] t) {
        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(t[n][sum] != -1){
            if(t[n-1][sum] == 1)
                return true;
            else
                return false;
        }

        if(arr[n-1] <= sum){
            boolean ans = subSetSumK(arr,n-1,sum-arr[n-1],t) || subSetSumK(arr,n-1,sum,t);
            if(ans == true)
                t[n][sum] = 1;
            else
                t[n][sum] = 0;
            return ans;
        }
        else {
            boolean ans = subSetSumK(arr,n-1,sum,t);
            if(ans == true)
                t[n][sum] = 1;
            else
                t[n][sum] = 0;
            return ans;
        }
    }
}
