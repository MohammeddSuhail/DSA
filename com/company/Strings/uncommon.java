package com.company.Strings;

public class uncommon {
    public static void main(String[] args) {
        System.out.println(findUncommonCharacters("coding","ninjas"));
    }

    public static String findUncommonCharacters(String s1, String s2) {
        // Write your code here.
        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++){
            System.out.println(s1.charAt(i));
            int index = (int)s1.charAt(i);
            System.out.println(index);
            freq[index]++;
        }

        for(int i=0;i<s2.length();i++){
            int index = (int)s2.charAt(i)-65;
            freq[index]++;
        }

        String ans="";

        for(int i=0;i<26;i++){
            if(freq[i]==1)
                ans +=(char)(i+65);
        }
        return ans;
    }
}
