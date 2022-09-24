package _4_DP.Striver_DP_Sheet._7_MCM;

/*
    https://www.codingninjas.com/codestudio/problems/palindrome-partitioning_873266?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */

import java.util.Arrays;

public class _53_Palindrome_Partitioning {
    /*
        Time complexity: O(n*2^n)
        Space complexity: O(n^2)

        Where 'n' is the length of the string
    */
    public static int palindromePartitioningRec(String str) {
        // Write your code here
        return palinPartRec(0,str.length()-1,str);
    }

    static int palinPartRec(int i, int j, String str){
        if(i==j){ //if only one ele, it's palindrome, so no partition
            return 0;
        }

        if(isPalind(i,j,str)) //it's palindrome, so no partition
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1;k++){
            int temp_ans = 1 + palinPartRec(i,k,str) + palinPartRec(k+1,j,str);
            min = Math.min(min, temp_ans);
        }

        return min;
    }

    static boolean isPalind(int i, int j, String str){
        while(i<=j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }




    /*
        Time complexity: O(n^3)
        Space complexity: O(n^2)

        Where 'n' is the length of the string
    */

    public static int palindromePartitioningMemo(String str) {
        // Write your code here
        int n= str.length();
        int[][] t = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(t[i],-1);

        return palinPartMemo(0,n-1,str,t);
    }

    static int palinPartMemo(int i, int j, String str, int[][] t){
        if(i==j){
            return 0;
        }

        if(isPalin(i,j,str))
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1;k++){
            int temp_ans = 1 + palinPartMemo(i,k,str,t) + palinPartMemo(k+1,j,str,t);
            min = Math.min(min, temp_ans);
        }

        return t[i][j] = min;
    }

    static boolean isPalin(int i, int j, String str){
        while(i<=j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
