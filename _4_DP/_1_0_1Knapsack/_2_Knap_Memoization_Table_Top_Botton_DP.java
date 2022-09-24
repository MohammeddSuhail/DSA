package _4_DP._1_0_1Knapsack;

public class _2_Knap_Memoization_Table_Top_Botton_DP {
    static int t[][];
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,3};
        int w=7;
        int n=wt.length;  //or int n = val.length;

        t=new int[n+1][w+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <w+1 ; j++)
                t[i][j]=-1;

        System.out.println(knapsack(wt,val,w,wt.length));
    }

    static int knapsack(int[] wt,int[] val,int w,int n){
        if(n==0 || w == 0)
            return 0;

        if(t[n][w] != -1)
            return t[n][w];

        //wt[n-1] because we place nth ele in n+1 pos, i.e, first row and col is reserved for initialization
        if(wt[n-1] <= w){  //option of take it or leave it
            return t[n][w] = Math.max((val[n-1]+knapsack(wt,val,w-wt[n-1],n-1)),knapsack(wt,val,w,n-1));
        }else {     //if(wt[n-1] > w) , i.e, only option is of leaving it
            return t[n][w] = knapsack(wt, val, w, n - 1);
        }
    }
}
