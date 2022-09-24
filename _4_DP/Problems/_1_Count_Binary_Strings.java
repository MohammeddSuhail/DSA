package _4_DP.Problems;


/*   check to understand
        https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count_binary_strings/topic

        let n = 4
              0  1  2  3  4
        dp0 : 0  1  1  2  3
        dp1 : 0  1  2  3  5

        dp0 is no of string len i(i.e, each 0 to 4) which starts from 0
        dp1 is no of string len i(i.e, each 0 to 4) which starts from 1
 */

import java.util.Scanner;

public class _1_Count_Binary_Strings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        //one way

        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp1[i-1];        // cur_no_of_strings_starting_from_zeros = prev_no_of_strings_starting_from_one
            dp1[i] = dp1[i-1] + dp0[i-1]; // cur_no_of_strings_starting_from_one = prev_no_of_strings_starting_from_one
            //                                       +prev_no_of_strings_starting_from_zeros
        }

        System.out.println(dp0[n] + dp1[n]);  //total no of strings with len n






        //second way

        int zeroes = 1;
        int ones = 1;
        for (int i = 2; i <= n; i++) {
            int nzeroes = ones;        // cur_no_of_strings_starting_from_zeros = prev_no_of_strings_starting_from_one
            int nones = ones + zeroes; // cur_no_of_strings_starting_from_one = prev_no_of_strings_starting_from_one
                                       //                                       +prev_no_of_strings_starting_from_zeros
            zeroes = nzeroes;
            ones = nones;
        }

        System.out.println(zeroes + ones);  //total no of strings with len n
    }
}
