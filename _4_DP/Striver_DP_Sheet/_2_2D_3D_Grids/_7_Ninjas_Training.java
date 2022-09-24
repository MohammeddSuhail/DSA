package _4_DP.Striver_DP_Sheet._2_2D_3D_Grids;

/*
    https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 */

import java.util.Arrays;

public class _7_Ninjas_Training {
    //just recursion
    /*
        time complexity: 3^n
        space complexity: n , for stack space
     */

    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        return fill(points,0,3);
    }

    static int fill(int[][] points, int index, int lastTOn){
        if(index == points.length)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i != lastTOn)
                max = Math.max(max, points[index][i]+fill(points,index+1,i));
        }

        return max;
    }




    //memoization
    /*
        Time Complexity: O(N*4*3)
        Reason: There are N*4 states and for every state, we are running a for loop iterating three times.

        Space Complexity: O(N) + O(N*4)
        Reason: We are using a recursion stack space(O(N)) and a 2D array (again O(N*4)).
        Therefore total space complexity will be O(N) + O(N) ≈ O(N)
     */
    public static int ninjaTrainingMemo(int n, int points[][]) {
        // Write your code here..
        int[][] t = new int[n][4];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);
        return fills(points,0,3,t);
    }

    static int fills(int[][] points, int index, int lastTOn, int[][] t){
        if(index == points.length)
            return 0;

        if(t[index][lastTOn] != -1)
            return t[index][lastTOn];

        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i != lastTOn)
                max = Math.max(max, points[index][i]+fills(points,index+1,i,t));
        }

        return t[index][lastTOn] = max;
    }
}
