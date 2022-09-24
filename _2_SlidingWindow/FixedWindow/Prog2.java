package _2_SlidingWindow.FixedWindow;

import java.util.PriorityQueue;

//first -ve num in fixed window size K

public class Prog2 {
    public static void main(String[] args) {
        int[] arr = {5,-4,3,-6,4,-17};
        int k=3; //window size
        negEleInKSize(arr,k);
    }

    static void negEleInKSize(int[] arr, int k) {
        int i=0,j=0;
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        while(j<n){
            if(arr[j]<0)
                q.add(arr[j]);

            if((j-i+1)<k) {
                j++;
            }
            else{
                if(q.isEmpty()){
                    System.out.println(0); //ans
                }else{
                    System.out.println(q.peek());  //ans
                    if(arr[i]==q.peek()){
                        System.out.println(q.remove());
                    }
                }
                i++;
                j++;
            }
        }
    }
}
