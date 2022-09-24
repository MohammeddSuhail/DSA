package _4_DP.Problems;

/*
        https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange_buildings/topic
            0  1  2  3  4
        B: string of size i ending with Building
        S: string of size i ending with space
 */

import java.util.Scanner;

public class _2_Arrange_Buildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //one way

        int[] B = new int[n+1];
        int[] S = new int[n+1];

        B[1] = 1;
        S[1] = 1;

        for (int i = 2; i <= n; i++) {
            B[i] = S[i-1];
            S[i] = S[i-1] + B[i-1];
        }
        int total = B[n] + S[n];

        System.out.println(total * total);  //total is one side of rode, so (square of train) is for both sides








        //second way with better space complexity

        int ob = 1;
        int os = 1;
        for (int i = 2; i <= n; i++) {
            int nb = os;
            int ns = os + ob;

            ob = nb;
            os = ns;
        }
        total = ob + os;

        System.out.println(total * total);  //total is one side of rode, so (square of train) is for both sides
    }
}
