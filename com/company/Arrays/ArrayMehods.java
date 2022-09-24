package com.company.Arrays;

import java.util.Arrays;

public class ArrayMehods {
    public static void main(String[] args) {
        int[] arr1 =new int[]{1,2,3,4,5};
        int[] arr2 =new int[]{1,4,3,6,5};

        System.out.println(Arrays.equals(arr1,arr2));  //false

        System.out.println(Arrays.binarySearch(arr1,4));  //3

        //                                           from       to       key
        System.out.println(Arrays.binarySearch(arr1,2,5,4));  //3

        System.out.println(Arrays.toString(arr1));      //[1, 2, 3, 4, 5]

        int[] arr3 = Arrays.copyOf(arr1,4);   //arr3 = [1, 2, 3, 4]
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = Arrays.copyOfRange(arr1,1,4);  // arr4 = [2, 3, 4]
        System.out.println(Arrays.toString(arr4));

        Arrays.sort(arr2);           //arr2 = [1, 3, 4, 5, 6];
        System.out.println(Arrays.toString(arr2));

        int[] arr5 = new int[]{5,4,7,3,8,1,0,9};
        //                  from      to
        Arrays.sort(arr5,1,5);         //arr5 = [5, 3, 4, 7, 8, 1, 0, 9]
        System.out.println(Arrays.toString(arr5));
    }
}
