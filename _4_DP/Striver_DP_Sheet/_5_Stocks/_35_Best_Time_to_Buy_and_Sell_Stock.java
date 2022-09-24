package _4_DP.Striver_DP_Sheet._5_Stocks;

import java.util.ArrayList;

public class _35_Best_Time_to_Buy_and_Sell_Stock {
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int buy = prices.get(0),maxProfit = 0;
        int n = prices.size();

        // Iterating over the array
        for(int i = 1; i < n; i++){
            /*
                If current price is less than buying price
                we will update buying price as the current price.
            */
            if(prices.get(i) < buy){
                buy = prices.get(i);
            }
            /*
                Else if selling at this price is more profitable,
                then we will update out maximum profit.
            */
            else if( (prices.get(i) - buy) > maxProfit){
                maxProfit = prices.get(i) - buy;
            }
        }
        return maxProfit;
    }
}
