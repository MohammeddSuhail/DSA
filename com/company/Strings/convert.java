package com.company.Strings;

import java.util.Locale;

public class convert {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        s = s.toUpperCase();
        while(i<j){
            if(!isAlnum(s.charAt(i))){
                i++;
            }
            if(!isAlnum(s.charAt(j))){
                j--;
            }
            if(isAlnum(s.charAt(i)) && isAlnum(s.charAt(j))){
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }else{
                    System.out.println(s.charAt(i) +" "+ s.charAt(j) +" "+i+" "+j);
                    return false;
                }
            }
        }
        return true;

    }
    static boolean isAlnum(char a){
        if(Character.isAlphabetic(a) || Character.isDigit(a)){
            return true;
        }
        return false;
    }
}
