package com.company.Arrays;

import java.util.Arrays;

public class sortNegPos {
    public static void main(String[] args) {
        int[] arr ={-4,-1,0,3,10};
        int[] ans = sortedSquares(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int ans[] = new int[n];
        int sq1,sq2,i=0,j=n-1,k=n-1;

        while(i<j){
            sq1=nums[i]*nums[i];
            sq2=nums[j]*nums[j];
            if(sq1>=sq2){
                ans[k--]=sq1;
                i++;
            }else{
                ans[k--]=sq2;
                j--;
            }
        }
        if(i==j){
            ans[k]=nums[i]*nums[j];
        }
        return ans;
    }
}



