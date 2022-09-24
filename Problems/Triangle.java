package Problems;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        triangle(new int[]{1, 2, 3, 4, 5});
    }

    static void triangle(int arr[]){
        int n = arr.length;
        triangleSum(arr,n);
    }

    static void triangleSum(int[] arr, int n) {
        if(n==0){
            return;
        }

        int[] a = Arrays.copyOfRange(arr,0,n);

        for (int i = 0; i < n-1; i++) {
            arr[i] = arr[i]+arr[i+1];
        }
        triangleSum(arr,n-1);

        System.out.println(Arrays.toString(a));
    }
}


//        [48]
//        [20, 28] -->(20 + 28 = 48)
//        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
//        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
//        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
