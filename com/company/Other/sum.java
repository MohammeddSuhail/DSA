package com.company.Other;

public class sum {
    public static void main(String[] args) {
        System.out.println(nSum(5));
    }

    static int nSum(int n){
        if(n==0)
            return 0;
        return n+nSum(n-1);
    }
}
