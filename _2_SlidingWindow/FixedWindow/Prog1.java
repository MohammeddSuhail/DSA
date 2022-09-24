package _2_SlidingWindow.FixedWindow;

//max sum of fixed window size K

public class Prog1 {
    public static void main(String[] args) {
        int[] arr = {5,3,4,7};
        int k=3; //window size
        maxSumOfKSize(arr,k);
    }

    static void maxSumOfKSize(int[] arr, int k) {
        int i=0,j=0;
        int n = arr.length;
        int maxSum=0;
        int sum=0;

        while(j<n){
            sum += arr[j];
            if((j-i+1)<k){
                j++;
            }
            else if((j-i+1)==k) {     //(j-i+1) gives size of window
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum -= arr[i];
                i++;
                j++;
            }
        }

        System.out.println(maxSum);
    }
}
