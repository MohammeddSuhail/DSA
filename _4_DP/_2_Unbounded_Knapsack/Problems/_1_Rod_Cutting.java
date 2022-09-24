package _4_DP._2_Unbounded_Knapsack.Problems;

//This problem is exactly unbounded knapsack, here we can cut pipe into same len's any of time
//Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
// Determine the maximum profit.
//len:[1,2,3,4]     i.e, wt Array
//price:[5,7,1,6]   i.e, val array
//total length of the array n is the knapsack limit

public class _1_Rod_Cutting {
    public static void main(String[] args) {
        int[] lengthArr = {1,2,3,4};
        int[] price = {5,7,1,6};
        int n = lengthArr.length;
        int totalLength=7;

        //memoization
        int[][] t=new int[n+1][totalLength+1];
        for (int i = 0; i <n+1 ; i++)
            for (int j = 0; j <totalLength+1 ; j++)
                t[i][j]=-1;

        System.out.println(rodCut(lengthArr,price,totalLength,n,t));
        System.out.println(UnboundedKnapsackMemo(lengthArr,price,totalLength,n,t));
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


    static int rodCut(int[] lengthArr, int[] price, int length,int n, int[][] t) {
        if(n==0 || length == 0)
            return 0;

        if(t[n][length] != -1)
            return t[n][length];

        //wt[n-1] because we place nth ele in n+1 pos, i.e, first row and col is reserved for initialization
        if(lengthArr[n-1] <= length){       //option of take it and stay on the same ele or leave it and move on to next ele
            return t[n][length] = Math.max(price[n-1]+rodCut(lengthArr,price,length-lengthArr[n-1],n,t),rodCut(lengthArr,price,length,n-1,t));
        }else      //if(wt[n-1] > w) , i.e, only option is of leaving it and moving next ele
            return t[n][length] = rodCut(lengthArr,price,length,n-1,t);
    }
}
