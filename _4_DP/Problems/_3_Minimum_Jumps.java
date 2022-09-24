package _4_DP.Problems;

/*
    https://www.codingninjas.com/codestudio/problems/minimum-jumps_1062693?leftPanelTab=0


    to reach 0 to n-1 with min jumps

    we will be given Arr where if at i index then we can hop arr[i] from there

    Just recursion:
    Time Complexity: O(N ^ N)
    Space complexity: O(N)  //auxiliary space

    With memoization:
    Time Complexity: O(N ^ 2)
    Space complexity: O(N)
 */

public class _3_Minimum_Jumps {

    public static int minimumJumps(int[] arr, int N) {

        long[] t = new long[N];
        long ans = jumping(0, arr, N, t);

        if(ans == Integer.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }

    static long jumping(int index, int[] arr, int N, long[] t){
        if(index == N-1){
            return 0;
        }

        if(index > N-1){
            return Integer.MAX_VALUE;
        }

        if(t[index] != 0)
            return t[index];

        long min = Integer.MAX_VALUE;

        for(int i = 1; i <= arr[index] && index+i<N; i++){
            min = Math.min(min , 1L + jumping(index+i,arr,N,t));
        }

        return t[index] = min;
    }

}