package com.company.Other;

import java.util.Arrays;
import java.util.Scanner;

public class perfNum{
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T;
        T=s.nextInt();
        s.nextLine();

        String inp;
        int start;
        int end;
        String[] str = new String[2];

        for(int i=0;i<T;i++){
            inp = s.nextLine();
            str = inp.split(" ");
            start= Integer.parseInt(str[0]);
            end = Integer.parseInt(str[1]);
            perfectSquare(start,end);
        }
    }

    private static void perfectSquare(int start, int end) {
        int sum=0,c=0;
        for(int num=start ;num<=end ; num++){
            sum=0;
            while(num!=0){
                sum+=num%10;
                num=num/10;
            }
            if(check(sum)){
                c++;
            }
        }
        System.out.println(c);
    }

    private static boolean check(int sum) {
        int a;
        for(int i=1;i<=sum;i++){
            a= (int) Math.pow(1,2);
            if(a>sum){
                return false;
            }
            if (a==sum)
                return true;
        }
        return false;
    }

}
