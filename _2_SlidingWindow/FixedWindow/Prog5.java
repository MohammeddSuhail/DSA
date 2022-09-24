package _2_SlidingWindow.FixedWindow;

//Prog for finding max prod of continuous 3 numbers
//wrong i guess

public class Prog5 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{5,1,2,5,7},3));
    }

    static int maximumProduct(int[] nums,int k) {
        int prod=1, maxProd = Integer.MIN_VALUE;
        int i=0,j=0,n=nums.length;

        while(j<n){
            prod*=nums[j];

            if(j-i+1 < k){
                j++;
            }else{
                if(prod>maxProd){
                    maxProd = prod;
                }
                if(nums[i]!=0){
                    prod=prod/nums[i];
                }
                i++;
                j++;
            }
        }

        return maxProd;
    }
}
