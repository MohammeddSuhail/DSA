package _4_DP.Striver_DP_Sheet._1_1D;

/*
    Same as _5_Maximum_sum_of_non_adjacent_elements

    https://www.codingninjas.com/codestudio/problems/loot-houses_630510?leftPanelTab=0

    Just recursion:
    Time Complexity: O(2^N)
    Space Complexity: O(N)   //auxiliary space

    Using Memoization:
    Time Complexity: O(N)
    Reason: The overlapping sub-problems will return the answer in constant time O(1).
    Therefore, the total number of new sub-problems we solve is ‘n’. Hence, total time complexity is O(N).

    Space Complexity: O(N)
    Reason: We are using a recursion stack space(O(N)) and an array (again O(N)).
    Therefore, total space complexity will be O(N) + O(N) ≈ O(N)
 */

import java.util.Arrays;

public class _6_House_Robber_1 {
    public static int maxMoneyLootedRec(int[] houses) {
        return lootRec(0, houses, houses.length);
    }

    //recursion
    static int lootRec(int index, int[] houses, int N){
        if(index >= N){
            return 0;
        }
        //take the ele at index and move by 2 index or don't take move to next index
        return Math.max(houses[index]+lootRec(index+2,houses,N), lootRec(index+1,houses,N));
    }


    //memoization
    static int[] t = null;
	public static int maxMoneyLootedMemo(int[] houses) {
		//Your code goes here
        int n = houses.length;
        t = new int[n];
        Arrays.fill(t,-1);

        return lootMemo(0, houses, n);
	}

    static int lootMemo(int index, int[] houses, int N){
        if(index >= N){
            return 0;
        }

        if(t[index] != -1)
            return t[index];

        //take the ele at index and move by 2 index or don't take move to next index
        return t[index] = Math.max(houses[index]+lootMemo(index+2,houses,N), lootMemo(index+1,houses,N));
    }
}
