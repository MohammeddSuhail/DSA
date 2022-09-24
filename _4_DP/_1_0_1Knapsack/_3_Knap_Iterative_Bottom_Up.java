package _4_DP._1_0_1Knapsack;

public class _3_Knap_Iterative_Bottom_Up {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,3};
        int w=7;
        int n=wt.length;  //or int n = val.length;

        System.out.println(knapsack(wt,val,w,wt.length));
    }

    static int knapsack(int[] wt,int[] val,int w,int n){
        int t[][] = new int[n+1][w+1];

        //n->i, w->j
        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j <w+1 ; j++) {
                if (i==0 || j==0){
                    t[i][j] = 0;
                }else if(wt[i-1]<=j){
                    t[i][j] = Math.max((val[i-1]+t[i-1][j-wt[i-1]]) , t[i-1][j]);
                }else if(wt[i-1]>w){
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][w];
    }
}
