package com.company.Other;

import java.util.Arrays;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        String rx;
        int candy=0;

        for(int i=0;i<n;i++){
            rx = s.nextLine();
            String[] str = rx.split(" ");
            int r = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);

            int capacity = 100*x;
            int req = 2*(22/7)*r;

            while(capacity>=req){
                capacity-=req;
                candy++;
            }
        }

        System.out.print(candy);
    }
}
