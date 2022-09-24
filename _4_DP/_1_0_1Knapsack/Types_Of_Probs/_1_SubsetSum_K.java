package _4_DP._1_0_1Knapsack.Types_Of_Probs;

/*
    Time Complexity: O(N*K)
    Reason: There are N*K states therefore at max ‘N*K’ new problems will be solved.
    K is target sum

    Space Complexity: O(N*K) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*K)).
 */

public class _1_SubsetSum_K {
    static int t[][];
    public static void main(String[] args) {
        int[] arr = {1,4,5,4,4};
        int sum=9;
        //System.out.println("Using just recursion: "+isThereEleSum(arr,sum,arr.length));

        int n= arr.length;
        t=new int[n+1][sum+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <sum+1 ; j++)
                t[i][j]=-1;

        System.out.println("Using Memoization: "+isThereEleSumMemoization(arr,sum,arr.length));

        //System.out.println("Using Memoization: "+isThereEleSumBottomUp(arr,sum,arr.length));
    }



    //just recursion                              n-> size
    static boolean isThereEleSum(int[] arr,int sum,int n){
        if(sum==0)
            return true;

        if(n==0){
            return false;
        }

        if(arr[n-1]<=sum){
            return (isThereEleSum(arr,sum-arr[n-1],n-1) || isThereEleSum(arr,sum,n-1));
        }else{
            return isThereEleSum(arr,sum,n-1);
        }
    }


    //Memoization
    //wt[]=>arr[]   w=>sum
    static boolean isThereEleSumMemoization(int[] arr,int sum,int n) {
        if (sum == 0)
            return true;

        if (n == 0) {
            return false;
        }

        if (t[n][sum] != -1) {
            if (t[n][sum] == 1)
                return true;
            else
                return false;
        }

        if (arr[n - 1] <= sum) {
            boolean res = (isThereEleSumMemoization(arr, sum - arr[n - 1], n - 1) || isThereEleSumMemoization(arr, sum, n - 1));
            if (res == true)
                t[n][sum] = 1;
            else
                t[n][sum] = 0;
            return res;
        } else {
            boolean res = isThereEleSumMemoization(arr, sum, n - 1);
            if (res == true)
                t[n][sum] = 1;
            else
                t[n][sum] = 0;
            return res;
        }
    }


    //BottomUp
    static boolean isThereEleSumBottomUp(int[] arr,int sum,int n){
        boolean[][] t=new boolean[n+1][sum+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <sum+1 ; j++) {

                //initialization
                if(i==0 && j==0)
                    t[i][j] = true;
                else if(i==0)           //if(n==0)
                    t[i][j] = false;
                else if(j==0)           //if(sum==0)
                    t[i][j] = true;
                else if(arr[i-1]<=j){   //ele<=sum   if(arr[n-1]<=sum)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];    //isThereEleSumMemoization(arr,sum-arr[n-1],n-1) || isThereEleSumMemoization(arr,sum,n-1)
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
