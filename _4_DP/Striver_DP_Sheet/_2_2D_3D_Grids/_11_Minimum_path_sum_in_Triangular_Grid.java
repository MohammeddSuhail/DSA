package _4_DP.Striver_DP_Sheet._2_2D_3D_Grids;
/*
    https://www.codingninjas.com/codestudio/problems/triangle_1229398?leftPanelTab=0
 */

import java.util.Arrays;

public class _11_Minimum_path_sum_in_Triangular_Grid {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        return minSum(0, 0, triangle,n);
    }

    //using recursion
    /*
        Time Complexity: O(2^(N*N))
        Because every ele can take 2 steps

        Space Complexity: O(N)
        Reason: We are using a recursion stack space: O((N)
     */
    static int minSum(int row, int col, int[][] triangle, int n){
        if(row == n)
            return 0;

        int down = Integer.MAX_VALUE, downRight = Integer.MAX_VALUE;

        if(row<n)
            down = triangle[row][col]+minSum(row+1,col,triangle,n);

        if(col<=row+1)
            downRight = triangle[row][col]+minSum(row+1,col+1,triangle,n);

        return Math.min(down,downRight);
    }



    //using memoization
    /*
    Time Complexity: O(N*N)
    Reason: At max, there will be (half of, due to triangle) N*N calls of recursion.

    Space Complexity: O(N) + O(N*N)
    Reason: We are using a recursion stack space: O((N), where N is the path length and an external DP Array of size ‘N*N’.
    */
    public static int minimumPathSumMemo(int[][] triangle, int n) {
        // Write your code here.
        int[][] t = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);

        return minSumMemo(0, 0, triangle,n,t);
    }

    static int minSumMemo(int row, int col, int[][] triangle, int n, int[][] t){
        if(row == n)
            return 0;

        if(t[row][col] != -1)
            return t[row][col];

        int down = Integer.MAX_VALUE, downRight = Integer.MAX_VALUE;

        if(row<n)
            down = triangle[row][col]+minSumMemo(row+1,col,triangle,n,t);

        if(col<=row+1)
            downRight = triangle[row][col]+minSumMemo(row+1,col+1,triangle,n,t);

        return t[row][col] = Math.min(down,downRight);
    }
}
