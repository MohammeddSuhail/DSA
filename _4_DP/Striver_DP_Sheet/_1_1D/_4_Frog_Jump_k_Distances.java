package _4_DP.Striver_DP_Sheet._1_1D;

/*
    https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/


    Using Memoization:
    Time Complexity: O(N *K)
    Reason: The overlapping sub-problems will return the answer in constant time.
    Therefore, the total number of new sub-problems we solve is ‘n’. At every new sub-problem,
    we are running another loop for K times. Hence, total time complexity is O(N * K).

    Space Complexity: O(N)
    Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
 */

import java.util.Arrays;

public class _4_Frog_Jump_k_Distances {
    public static void main(String[] args) {
        int height[]={30,10,60 , 10 , 60 , 50};
        int n = height.length;

        int t[] = new int[n];
        Arrays.fill(t,-1);

        //one way
        System.out.println(jump(0,height, n, t));

        //other way
        Arrays.fill(t,-1);
        System.out.println(jumps(n-1,height,t));

        Arrays.fill(t,-1);
    }

    static int jump(int index, int[] heights,int n, int t[]){
        if(index == n-1){
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        int min = Integer.MAX_VALUE;

        for (int i = index+1; i<n; i++){
            min = Math.min(min, Math.abs(heights[index]-heights[i])+jump(i,heights, n, t));
        }

        return t[index] = min;
    }

    //other way
    static int jumps(int index, int[] heights, int t[]){
        if(index == 0){
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        int min = Integer.MAX_VALUE;

        for (int i = index-1; i>=0; i--){
            min = Math.min(min, Math.abs(heights[index]-heights[i])+jumps(i,heights, t));
        }

        return t[index] = min;
    }
}
