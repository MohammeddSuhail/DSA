package _4_DP.Striver_DP_Sheet._5_Stocks;

/*
    https://www.codingninjas.com/codestudio/problems/rahul-and-his-chocolates_3118974?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

    Time Complexity: O(N*2)
    Reason: There are N*2 states therefore at max ‘N*2’ new problems will be solved and we are running a for loop for ‘N’ times to calculate the total sum

    Space Complexity: O(N*2) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*2)).
 */

import java.util.Arrays;

public class _40_Best_Time_to_Buy_and_Sell_Stock_transac_fee {
    public static int maximumProfit(int n, int fee, int[] prices) {
        int[][] t = new int[n][2];
        for(int[] row: t)
            Arrays.fill(row,-1);

        return maxProfit(0,prices,0,t,fee);
    }
    //if buy=0 means u can buy
    static int maxProfit(int index, int[] values, int buy, int[][] t,int fee){
        if(index == values.length)
            return 0;

        if(t[index][buy] != -1)
            return t[index][buy];

        if(buy==0){//allowed to buy, so buy or not buy
            int take = -values[index] + maxProfit(index+1,values,1,t,fee);
            int dontTake = maxProfit(index+1,values,0,t,fee);
            return t[index][buy] = Math.max(take,dontTake);
        }else{//sell or don't sell
            int sell = values[index] - fee + maxProfit(index+1,values,0,t,fee);
            int dontSell = maxProfit(index+1,values,1,t,fee);
            return t[index][buy] = Math.max(sell,dontSell);
        }
    }
}
