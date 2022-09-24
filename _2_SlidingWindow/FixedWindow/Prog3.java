package _2_SlidingWindow.FixedWindow;

//Occurrences of times anagram of pat was there in Str

import java.util.Arrays;

public class Prog3 {
    public static void main(String[] args) {
        String str = "vehheevhsshvvvvevdsveh";
        String pat = "evh";
        System.out.println("No of times anagram of pat was there in Str: "+ noOfOccur(str,pat));
    }

    static int noOfOccur(String str, String pat) {

        int k=pat.length();
        int[] actual = new int[26];
        int curCharIndex;

        for (int l = 0; l < k; l++) {
            curCharIndex = ((int) pat.charAt(l)) - 97;
            actual[curCharIndex]++;
        }

        int i=0, j=0, count = 0, n=str.length();
        int[] current = new int[26];

        while(j<n){
            curCharIndex = ((int) str.charAt(j)) - 97;
            current[curCharIndex]++;

            if(j-i+1 < k){
                j++;
            }else{    // i.e, j-i+1 == k
                if(Arrays.equals(actual,current)){
                    count++;
                }
                int ithInd = ((int) str.charAt(i)) - 97;
                current[ithInd]--;
                i++;
                j++;
            }
        }

        return count;
    }
}
