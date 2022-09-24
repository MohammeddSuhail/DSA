package _4_DP.Striver_DP_Sheet._1_1D;

/*
    https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

    Using Recursion:
    Time Complexity: O(2^N)

    Using Memoization:
    Time Complexity: O(N)
    Reason: The overlapping sub-problems will return the answer in constant time O(1).
    Therefore, the total number of new sub-problems we solve is ‘n’. Hence, total time complexity is O(N).

    Space Complexity: O(N)
    Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
 */

public class _3_Frog_Jump {

    public static void main(String[] args) {
        int[] heights = {10,30,7,8,50};
        int n = heights.length;

        //one way
        System.out.println(frogJump(n,heights));

        //other way
        t = new int[n];
        System.out.println(jumps(n-1, heights));

        //Bottom Up
        System.out.println(jumpBottomUp(heights,n));
    }
    static int[] t = null;
    public static int frogJump(int n, int heights[]) {
        t = new int[n];
        return jump(0, heights, n);
    }

    static int jump(int index, int[] heights,int n){
        if(index == n-1){
            return 0;
        }

        if(t[index] != 0)
            return t[index];

        if(index+2 <= n-1){ //can take 1 or 2 steps
            return t[index] = Math.min(Math.abs(heights[index]-heights[index+1])+jump(index+1,heights, n),
                                       Math.abs(heights[index]-heights[index+2])+jump(index+2,heights, n));
        }else{  //can only take 1 steps
            return t[index] = Math.abs(heights[index]-heights[index+1])+jump(index+1,heights, n);
        }
    }

    static int jumps(int n, int[] heights){
        if(n == 0){
            return 0;
        }

        if(t[n] != 0)
            return t[n];

        if(n-2 >= 0){ //can take 1 or 2 steps
            return t[n] = Math.min(Math.abs(heights[n]-heights[n-1])+jumps(n-1,heights),
                    Math.abs(heights[n]-heights[n-2])+jumps(n-2,heights));
        }else{  //can only take 1 steps
            return t[n] = Math.abs(heights[n]-heights[n-1])+jumps(n-1,heights);
        }
    }

    /*
    Time Complexity: O(N)
    Reason: We are running a simple iterative loop

    Space Complexity: O(N)
    Reason: We are using an external array of size ‘n+1’.
    */

    static int jumpBottomUp(int[] heights,int n){
        int[]  t = new int[n];

        t[0] = 0;
        for (int i=1;i<n;i++){
            if(i-2>=0)
                t[i] = Math.min(Math.abs(heights[i]-heights[i-1]) + t[i-1],Math.abs(heights[i]-heights[i-2]) + t[i-2]);
            else
                t[i] = Math.abs(heights[i]-heights[i-1]) + t[i-1];
        }

        return t[n-1];
    }
}
