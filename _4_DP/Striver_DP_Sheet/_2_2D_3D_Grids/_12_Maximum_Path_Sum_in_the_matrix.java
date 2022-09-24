package _4_DP.Striver_DP_Sheet._2_2D_3D_Grids;

/*
    https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */

import java.util.Arrays;

public class _12_Maximum_Path_Sum_in_the_matrix {
    //using recursion
    /*
        Time Complexity: O((M*3)^(N*N))
        Because M starting point and every ele can take 3 steps

        Space Complexity: O(N)
        Reason: We are using a recursion stack space: O((N)
     */
    public static int getMaxPathSum(int[][] matrix) {
        // Write your code here
        int n = matrix.length, m = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            max = Math.max(max,getMaxSum(0,i,matrix,n,m));
        }

        return max;
    }

    static int getMaxSum(int row, int col, int[][] matrix, int n, int m){
        if(row == n)
            return 0;

        int down = Integer.MIN_VALUE, downLeft = Integer.MIN_VALUE, downRight = Integer.MIN_VALUE;

        if(row<n)
            down = matrix[row][col]+getMaxSum(row+1,col,matrix,n,m);

        if(row<n && col>0)
            downLeft = matrix[row][col]+getMaxSum(row+1,col-1,matrix,n,m);

        if(row<n && col<m-1)
            downRight = matrix[row][col]+getMaxSum(row+1,col+1,matrix,n,m);

        return Math.max(down, Math.max(downLeft,downRight));
    }




    /*  //using memoization
        Time Complexity : O(N*M)
        Space Complexity : O(N*M)
     */
    public static int getMaxPathSumMemo(int[][] matrix) {
        // Write your code here
        int n = matrix.length, m = matrix[0].length;
        int[][] t = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);


        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max = Math.max(max,getMaxSumMemo(0,i,matrix,n,m,t));
        }

        return max;
    }

    static int getMaxSumMemo(int row, int col, int[][] matrix, int n, int m, int[][] t){
        if(row == n)
            return 0;

        if(t[row][col] != -1)
            return t[row][col];

        int down = Integer.MIN_VALUE, downLeft = Integer.MIN_VALUE, downRight = Integer.MIN_VALUE;

        if(row<n)
            down = matrix[row][col]+getMaxSumMemo(row+1,col,matrix,n,m,t);

        if(row<n && col>0)
            downLeft = matrix[row][col]+getMaxSumMemo(row+1,col-1,matrix,n,m,t);

        if(row<n && col<m-1)
            downRight = matrix[row][col]+getMaxSumMemo(row+1,col+1,matrix,n,m,t);

        return t[row][col] = Math.max(down, Math.max(downLeft,downRight));
    }
}

