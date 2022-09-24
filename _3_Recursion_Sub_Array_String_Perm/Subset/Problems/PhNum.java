package _3_Recursion_Sub_Array_String_Perm.Subset.Problems;

import java.util.ArrayList;
import java.util.List;

public class PhNum {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }

    static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        letterComb("",digits,list);
        return list;
    }

    static void letterComb(String p ,String digits, List<String> list) {
        if(digits.isEmpty()){
            list.add(p);
            return;
        }

        String[] dString = {"","","abc","def","ghi","jkl","nmo","pqrs","tuv","wxyz"};

        int index  = Character.getNumericValue(digits.charAt(0));
        String curDigitString = dString[index];

        for (int i = 0; i < curDigitString.length(); i++) {
            letterComb(p+curDigitString.charAt(i),digits.substring(1),list);
        }
    }


}
