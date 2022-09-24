package _4_DP._1_0_1Knapsack;

//not  DP
public class _1_Knap_not_DP {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,3};

        System.out.println(knapsack(wt,val,7,wt.length));
    }

    static int knapsack(int[] wt,int[] val,int w,int n){
        if(n==0 || w == 0)
            return 0;

        //wt[n-1] because we place nth ele in n+1 pos, i.e, first row and col is reserved for initialization
        if(wt[n-1] <= w){       //option of take it or leave it
            return Math.max((val[n-1]+knapsack(wt,val,w-wt[n-1],n-1)),knapsack(wt,val,w,n-1));
        }else      //if(wt[n-1] > w) , i.e, only option is of leaving it
            return knapsack(wt,val,w,n-1);

    }
}
