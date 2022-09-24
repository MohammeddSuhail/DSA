package _2_SlidingWindow.VariableWindow;

//maximum size of sub-array length whose sum is k

public class Prog1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int k=12;

        System.out.println("max sub-array size whose sum is k : " + getMaxSubArraySize(arr,k));
    }

    private static int getMaxSubArraySize(int[] arr, int k) {
        int i=0, j=0 , n = arr.length;
        int sum = 0 , maxSize = 0;

        while(j<n){

            sum += arr[j];

            if(sum<k){
                j++;
            }else if(sum==k){
                if((j-i+1) > maxSize) {
                    maxSize = j - i + 1;
                }
                j++;
            }else if(sum>k){
                while(sum>k){
                    sum-=arr[i];
                    i++;
                }
                //now sum will sum is not > k so check if sum==k before adding new ele, j++
                if(sum==k){
                    if((j-i+1) > maxSize) {
                        maxSize = j - i + 1;
                    }
                }
                j++;
            }
        }
        return maxSize;
    }
}
