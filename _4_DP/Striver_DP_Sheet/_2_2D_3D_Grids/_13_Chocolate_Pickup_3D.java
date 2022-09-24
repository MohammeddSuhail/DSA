package _4_DP.Striver_DP_Sheet._2_2D_3D_Grids;

/*
    https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */

import java.util.Arrays;

public class _13_Chocolate_Pickup_3D {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        return maxChoc(0,0,c-1,grid);
    }
    /*  There are 3 ways both alice and bob can so
        so 3**3 = 9 ways
        that means we should call 9 function calls


        i+1,j-1    i+1,j   i+1,j+1

        i+1 is same, but j is subtracted/added by -1,0,1
        for d=-1 to 1
            col+d
    */

    /*
        just recursion:
        time complexity: 3^n * 3^n
        space complexity: n
     */
    static int maxChoc(int row, int col1, int col2, int[][] grid){
        if(row == grid.length)
            return 0;

        //out of bounds
        if(col1<0 || col1>grid[0].length-1 || col2<0 || col2>grid[0].length-1)
            return (int)(Math.pow(-10, 9)); //just return a large value, can return MAX_VALUE but overflow issue

        int max = Integer.MIN_VALUE;
        for(int dcol1=-1;dcol1<=1;dcol1++){//for each col value of Alice
            for(int dcol2=-1;dcol2<=1;dcol2++){//for each col value of Bob
                if(col1 == col2) //only pick once
                    max = Math.max(max,grid[row][col1]+maxChoc(row+1,col1+dcol1,col2+dcol2,grid));
                else
                    max = Math.max(max,grid[row][col1]+grid[row][col2]+maxChoc(row+1,col1+dcol1,col2+dcol2,grid));
            }
        }

        return max;
    }




    //memoization
    /*
        Time Complexity: O(N*M*M) * 9
        Reason: At max, there will be N*M*M calls of recursion to solve a new problem and in every call,
        two nested loops together run for 9 times.

        Space Complexity: O(N) + O(N*M*M)
        Reason: We are using a recursion stack space: O(N),
        where N is the path length and an external DP Array of size ‘N*M*M’.
     */
    public static int maximumChocolatesMemo(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] t = new int[r][c][c];
        for (int row1[][]: t) {
            for (int row2[]: row1) {
                Arrays.fill(row2, -1);
            }
        }
        return maxChocMemo(0,0,c-1,grid,t);
    }
    static int maxChocMemo(int row, int col1, int col2, int[][] grid, int[][][] t){
        if(row == grid.length)
            return 0;

        //out of bounds
        if(col1<0 || col1>grid[0].length-1 || col2<0 || col2>grid[0].length-1)
            return (int)(Math.pow(-10, 9)); //just return a large value

        if(t[row][col1][col2] != -1)
            return t[row][col1][col2];

        int max = Integer.MIN_VALUE;
        for(int dcol1=-1;dcol1<=1;dcol1++){//for each col value of Alice
            for(int dcol2=-1;dcol2<=1;dcol2++){//for each col value of Bob
                if(col1 == col2) //alice and bob are at same index only pick once
                    max = Math.max(max,grid[row][col1]+maxChocMemo(row+1,col1+dcol1,col2+dcol2,grid,t));
                else
                    max = Math.max(max,grid[row][col1]+grid[row][col2]+maxChocMemo(row+1,col1+dcol1,col2+dcol2,grid,t));
            }
        }

        return t[row][col1][col2] = max;
    }
}
