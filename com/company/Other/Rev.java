package com.company.Other;

public class Rev {
    public static void main(String[] args) {
        revNum(1234);
    }

    static void revNum(int num){
        int rem,sum=0;
        while(num!=0){
            rem=num%10;
            sum=sum*10+rem;
            num=num/10;
        }
        System.out.println(sum);
    }
}
