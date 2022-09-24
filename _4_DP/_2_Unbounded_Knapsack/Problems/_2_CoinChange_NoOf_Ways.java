package _4_DP._2_Unbounded_Knapsack.Problems;

//https://leetcode.com/problems/coin-change-2/

public class _2_CoinChange_NoOf_Ways {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        //memoization
        int[][] t=new int[n+1][amount+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <amount+1 ; j++)
                t[i][j]=-1;

        return UnboundedKnapsackMemo(coins,amount,n,t);
    }

    int UnboundedKnapsackMemo(int[] wt, int w, int n, int[][] t) {
        if(w == 0)
            return 1;

        if(n == 0)
            return 0;

        if(t[n][w] != -1)
            return t[n][w];

        if(wt[n-1] <= w){
            return t[n][w] = UnboundedKnapsackMemo(wt,w-wt[n-1],n,t) + UnboundedKnapsackMemo(wt,w,n-1,t);
        }else
            return t[n][w] = UnboundedKnapsackMemo(wt,w,n-1,t);
    }
}
