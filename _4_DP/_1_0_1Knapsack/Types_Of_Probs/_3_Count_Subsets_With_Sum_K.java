package _4_DP._1_0_1Knapsack.Types_Of_Probs;

public class _3_Count_Subsets_With_Sum_K {
    public static void main(String[] args) {
        int[] arr = {3,4,1,6,1};
        int sum = 6;
        int n = arr.length;

        System.out.println(Count_Subsets_With_Sum_K_A(arr,n,sum));
        System.out.println(Count_Subsets_With_Sum_K_B(arr,n,sum));

        //memoization
        int[][] t = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
            for (int j = 0; j < sum+1; j++)
                t[i][j] = -1;

        System.out.println(Count_Subsets_With_Sum_K_Memo(arr,n,sum,t));
    }

    static int Count_Subsets_With_Sum_K_A(int[] arr, int n, int sum) {
        if(sum == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        return Count_Subsets_With_Sum_K_A(arr,n-1,sum-arr[n-1]) + Count_Subsets_With_Sum_K_A(arr,n-1,sum);
    }

    static int Count_Subsets_With_Sum_K_B(int[] arr, int n, int sum) {
        if(sum == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(arr[n-1] <= sum){ //if possible to take, then include or ignore
            return Count_Subsets_With_Sum_K_B(arr,n-1,sum-arr[n-1]) + Count_Subsets_With_Sum_K_B(arr,n-1,sum);
        }else{ //not possible to take
            return Count_Subsets_With_Sum_K_B(arr,n-1,sum);
        }
    }

    //memoization
    static int Count_Subsets_With_Sum_K_Memo(int[] arr, int n, int sum, int[][] t) {
        if(sum == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(t[n][sum] != -1){ //that means already computed
            return t[n][sum];
        }

        if(arr[n-1] <= sum){ //if possible to take, then include or ignore
            return t[n][sum] = Count_Subsets_With_Sum_K_Memo(arr,n-1,sum-arr[n-1],t) + Count_Subsets_With_Sum_K_Memo(arr,n-1,sum,t);
        }else{ //not possible to take
            return t[n][sum] = Count_Subsets_With_Sum_K_Memo(arr,n-1,sum,t);
        }
    }
}
