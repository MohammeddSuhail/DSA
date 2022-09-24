package com.company.Strings;

public class PreChar {
    public static void main(String[] args) {

    }

    //1 way
    static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length ==0){
            return "";
        }
        String pref = strs[0];
        for(int i=1;i<strs.length;i++){
            pref = commonPref(pref, strs[i]);   //each time finding the common up till now and next adjacent String
        }
        return pref;
    }
    static String commonPref(String left, String right){
        int min = Math.min(left.length(), right.length());
        for(int i =0; i< min ; i++){
            if(left.charAt(i)!= right.charAt(i)){
                return left.substring(0, i);       // or return right.substring(0, i)
            }
        }
        return left.substring(0,min);      // or return right.substring(0, i)
    }





    //2nd way
    public String longestCommPrefix(String[] strs) {
        String ans="";
        char c;

        if(strs.length ==0){
            return ans;
        }

        for(int i=0;i<strs[0].length();i++){
            c = strs[0].charAt(i);

            for(int j=1;j<strs.length;j++){
                if(i==strs[i].length() || strs[i].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }

        }
        return  strs[0];
    }

}
