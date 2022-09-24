package _4_DP.Striver_DP_Sheet._5_Stocks;

/*
    https://www.codingninjas.com/codestudio/problems/best-time-to-buy-and-sell-stock_1080698?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 */

import java.util.Arrays;

public class _38_Best_Time_to_Buy_and_Sell_Stock_4 {
    /*
        Time Complexity: O(N*2*k)
        Reason: There are N*2*K states therefore at max ‘N*2*K’ new problems will be solved.

        Space Complexity: O(N*2*K) + O(N)
        Reason: We are using a recursion stack space(O(N)) and a 3D array ( O(N*2*K)).
     */

    public static int maximumProfit(int[] prices, int n, int k)
    {
        int[][][] t = new int[n][2][k];
        for(int[][] row: t)
            for(int[] r: row)
                Arrays.fill(r,-1);

        return maxProfitsMemo(0,prices,0,0,t,k);
    }

    //if buy=0 means u can buy
    static int maxProfitsMemo(int index, int[] values, int buy, int noOfTran, int[][][] t, int k){
        if(index == values.length)
            return 0;

        if(noOfTran==k)
            return 0;

        if(t[index][buy][noOfTran] != -1)
            return t[index][buy][noOfTran];

        if(buy==0){//allowed to buy, so buy or not buy
            int take = -values[index] + maxProfitsMemo(index+1,values,1,noOfTran,t,k);
            int dontTake = maxProfitsMemo(index+1,values,0,noOfTran,t,k);
            return t[index][buy][noOfTran] = Math.max(take,dontTake);
        }else{//can sell or don't sell
            int sell = values[index] + maxProfitsMemo(index+1,values,0,noOfTran+1,t,k);
            int dontSell = maxProfitsMemo(index+1,values,1,noOfTran,t,k);
            return t[index][buy][noOfTran] = Math.max(sell,dontSell);
        }
    }
}
