package com.company.Strings;

import java.util.Arrays;

public class RevWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    static String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (String str:
             strs) {
            System.out.println(str.length());
        }

        System.out.println(strs.length+" :"+Arrays.toString(strs));

        int n = strs.length;
        for(int i=0; i<n/2; i++){
            String temp = strs[i];
            strs[i] = strs[n-i-1];
            strs[n-i-1] = temp;
        }
        System.out.println(strs.length+" :"+Arrays.toString(strs));

        String ans = "";

        for(int i=0;i<n;i++){
            ans += strs[i];
            if(i != n-1)
                ans += " ";
        }

        return ans;
    }
}
