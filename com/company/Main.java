package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Main
{
        public static void main(String[] args) {
                Scanner s =new Scanner(System.in);

                System.out.println("Enter:");
                String str = s.nextLine();
                String[] arrStr = str.split(" ");
                System.out.println("After split: "+Arrays.toString(arrStr));
                int[] arr = new int[arrStr.length];
                for (int i = 0; i < arrStr.length; i++) {
                        arr[i] = Integer.parseInt(arrStr[i]);
                }
                System.out.println("arr: "+Arrays.toString(arr));
        }

}





