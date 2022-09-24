package _4_DP._2_Unbounded_Knapsack;

//t: x->ele's from index 1 to n
//   y->sum(i.e, weight)

public class _Unbounded_Knapsack {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,6,5,3};
        int n = wt.length;
        int w=7;

        System.out.println(UnboundedKnapsack(wt,val,w,n));

        //memoization
        int[][] t=new int[n+1][w+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <w+1 ; j++)
                t[i][j]=-1;

        System.out.println(UnboundedKnapsackMemo(wt,val,w,n,t));
    }

    static int UnboundedKnapsack(int[] wt,int[] val,int w,int n){
        if(n==0 || w == 0)
            return 0;

        //wt[n-1] because we place nth ele in n+1 pos, i.e, first row and col is reserved for initialization
        if(wt[n-1] <= w)       //option of take it and stay on the same ele or leave it and move on to next ele
            return Math.max((val[n-1]+UnboundedKnapsack(wt,val,w-wt[n-1],n)),UnboundedKnapsack(wt,val,w,n-1));
        else      //if(wt[n-1] > w) , i.e, only option is of leaving it and moving next ele
            return UnboundedKnapsack(wt,val,w,n-1);
    }


    static int UnboundedKnapsackMemo(int[] wt, int[] val, int w, int n, int[][] t) {
        if(n==0 || w == 0)
            return 0;

        if(t[n][w] != -1)
            return t[n][w];

        //wt[n-1] because we place nth ele in n+1 pos, i.e, first row and col is reserved for initialization
        if(wt[n-1] <= w){       //option of take it and stay on the same ele or leave it and move on to next ele
            return t[n][w] = Math.max((val[n-1]+UnboundedKnapsackMemo(wt,val,w-wt[n-1],n,t)),UnboundedKnapsackMemo(wt,val,w,n-1,t));
        }else      //if(wt[n-1] > w) , i.e, only option is of leaving it and moving next ele
            return t[n][w] = UnboundedKnapsackMemo(wt,val,w,n-1,t);
    }
}
