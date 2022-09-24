package _4_DP.Striver_DP_Sheet._5_Stocks;

/*
    https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 */

import java.util.ArrayList;
import java.util.Arrays;

public class _37_Best_Time_to_Buy_and_Sell_Stock_3 {
    /*
        Recursion:
        Time Complexity: O(N^2)
        Reason: There are N*2*3 states therefore at max ‘N*2*3’ new problems will be solved.

        Space Complexity: O(N)
     */
    public static int maxProfitRec(ArrayList<Integer> prices, int n) {
        // Write your code here.
        return maxProfitsRec(0,prices,0,0);
    }

    //if buy=0 means u can buy
    static int maxProfitsRec(int index, ArrayList<Integer> values, int buy, int noOfTran){
        if(index == values.size())
            return 0;

        if(noOfTran==2)
            return 0;

        if(buy==0){//allowed to buy, so buy or not buy
            int take = -values.get(index) + maxProfitsRec(index+1,values,1,noOfTran);
            int dontTake = maxProfitsRec(index+1,values,0,noOfTran);
            return Math.max(take,dontTake);
        }else{//can sell or don't sell
            int sell = values.get(index) + maxProfitsRec(index+1,values,0,noOfTran+1);
            int dontSell = maxProfitsRec(index+1,values,1,noOfTran);
            return Math.max(sell,dontSell);
        }
    }




    /*  Memoization:

        Time Complexity: O(N*2*3)
        Reason: There are N*2*3 states therefore at max ‘N*2*3’ new problems will be solved.

        Space Complexity: O(N*2*3) + O(N)
        Reason: We are using a recursion stack space(O(N)) and a 3D array ( O(N*2*3)).
     */

    public static int maxProfitMmeo(ArrayList<Integer> prices, int n) {
        // Write your code here.
        int[][][] t = new int[n][2][3];
        for(int[][] row: t)
            for(int[] r: row)
                Arrays.fill(r,-1);

        return maxProfitsMemo(0,prices,0,0,t);
    }

    //if buy=0 means u can buy
    static int maxProfitsMemo(int index, ArrayList<Integer> values, int buy, int noOfTran, int[][][] t){
        if(index == values.size())
            return 0;

        if(noOfTran==2)
            return 0;

        if(t[index][buy][noOfTran] != -1)
            return t[index][buy][noOfTran];

        if(buy==0){//allowed to buy, so buy or not buy
            int take = -values.get(index) + maxProfitsMemo(index+1,values,1,noOfTran,t);
            int dontTake = maxProfitsMemo(index+1,values,0,noOfTran,t);
            return t[index][buy][noOfTran] = Math.max(take,dontTake);
        }else{//can sell or don't sell
            int sell = values.get(index) + maxProfitsMemo(index+1,values,0,noOfTran+1,t);
            int dontSell = maxProfitsMemo(index+1,values,1,noOfTran,t);
            return t[index][buy][noOfTran] = Math.max(sell,dontSell);
        }
    }
}
