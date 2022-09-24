package _4_DP._2_Unbounded_Knapsack.Problems;

//https://leetcode.com/problems/coin-change/

import java.util.*;

public class _3_CoinChange_Min_NoOf_Coins {
    static int[][] t = null;
    public int coinChangeMyWay(int[] coins, int amount) {

        int n = coins.length;
        t = new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);

        int ans = coinEx(0, amount, coins);

        if(ans == (int)Math.pow(10,9))
            return -1;
        else
            return ans;
    }

    int coinEx(int index, int amount, int[] coins){
        if(amount == 0)
            return 0;

        if(index == coins.length)
            return (int)Math.pow(10,9);

        if(t[index][amount] != -1)
            return t[index][amount];

        if(coins[index]<=amount){
            return t[index][amount] = Math.min(1+coinEx(index,amount-coins[index],coins), coinEx(index+1,amount,coins));
        }else{
            return t[index][amount] = coinEx(index+1,amount,coins);
        }
    }





    //same, just from back
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        //memoization
        int[][] t=new int[n+1][amount+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <amount+1 ; j++)
                t[i][j]=-1;

        int ans = UnboundedKnapsackMemo(coins,amount,n,t);

        if(ans == Integer.MAX_VALUE-1)  //not possible to form, if it returns Integer.MAX_VALUE-1 or comparing between
            return -1;                  //(Integer.MAX_VALUE-1)+1 and Integer.MAX_VALUE-1

        return ans;
    }

    int UnboundedKnapsackMemo(int[] wt, int w, int n, int[][] t) {
        if(w == 0)
            return 0;

        if(n == 0)
            return Integer.MAX_VALUE-1; //Integer.MAX_VALUE-1, because below code we add 1 to the function call,so int may overflow so

        if(t[n][w] != -1)
            return t[n][w];

        if(wt[n-1] <= w){
            return t[n][w] = Math.min(1+UnboundedKnapsackMemo(wt,w-wt[n-1],n,t),UnboundedKnapsackMemo(wt,w,n-1,t));
        }else
            return t[n][w] = UnboundedKnapsackMemo(wt,w,n-1,t);
    }
}


/*      if it was indian currency

        int c=0, n = coins.length;

        Arrays.sort(coins);

        for(int i=0;i<(n/2);i++){
            int temp = coins[i];
            coins[i] = coins[n-i-1];
            coins[n-i-1] = temp;
        }
        int a = amount;
        for(int i=0;i<n;i++){
            c += amount/coins[i];
            amount -= (amount/coins[i]) * coins[i];
        }

        if(amount==0)
            return c;
        else
            return -1;
*/

