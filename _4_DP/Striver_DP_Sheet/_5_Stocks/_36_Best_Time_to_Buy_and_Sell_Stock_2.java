package _4_DP.Striver_DP_Sheet._5_Stocks;

/*
    https://www.codingninjas.com/codestudio/problems/selling-stock_630282?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

    Just Recursion:
    Time complexity: 2^n
    Space complexity: n


    Memoization:
    Time Complexity: O(N*2)
    Reason: There are N*2 states therefore at max ‘N*2’ new problems will be solved and
    we are running a for loop for ‘N’ times to calculate the total sum

    Space Complexity: O(N*2) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*2)).
 */

import java.util.Arrays;

public class _36_Best_Time_to_Buy_and_Sell_Stock_2 {
    public static long getMaximumProfit (int n, long[] values) {
        // Your code goes here.
        return maxProfitRec(0,values,0);
    }
    //if buy=0 means u can buy
    static long maxProfitRec(int index, long[] values, int buy){
        if(index == values.length)
            return 0;

        if(buy==0){//allowed to buy, so buy or not buy
            long take = -values[index] + maxProfitRec(index+1,values,1);
            long dontTake = maxProfitRec(index+1,values,0);
            return Math.max(take,dontTake);
        }else{//can sell or don't sell
            long sell = values[index] + maxProfitRec(index+1,values,0);
            long dontSell = maxProfitRec(index+1,values,1);
            return Math.max(sell,dontSell);
        }
    }




    public static long getMaximumProfitMemo (int n, long[] values) {
        // Your code goes here.
        long[][] t = new long[n][2];
        for(long[] row: t)
            Arrays.fill(row,-1);

        return maxProfit(0,values,0,t);
    }
    //if buy=0 means u can buy
    static long maxProfit(int index, long[] values, int buy, long[][] t){
        if(index == values.length)
            return 0;

        if(t[index][buy] != -1)
            return t[index][buy];

        if(buy==0){//allowed to buy, so buy or not buy
            long take = -values[index] + maxProfit(index+1,values,1,t);
            long dontTake = maxProfit(index+1,values,0,t);
            return t[index][buy] = Math.max(take,dontTake);
        }else{//can sell or don't sell
            long sell = values[index] + maxProfit(index+1,values,0,t);
            long dontSell = maxProfit(index+1,values,1,t);
            return t[index][buy] = Math.max(sell,dontSell);
        }
    }
}
