package Problems;

import java.util.HashMap;
import java.util.Stack;

public class _1_valid_paran {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<>();
        HashMap<Character,Character> hMap = new HashMap<>();
        hMap.put(')','(');
        hMap.put('}','{');
        hMap.put(']','[');

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                sk.push(s.charAt(i));
            }else{
                if(sk.size()==0)
                    return false;
                Character expected = hMap.get(s.charAt(i));
                Character actual = sk.pop();
                if(expected != actual)
                    return false;
            }
        }
        if(sk.size()==0)
            return true;
        else
            return false;
    }
}
