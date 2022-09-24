package _2_SlidingWindow.VariableWindow;

//largest sub-string with unique characters

import java.util.HashMap;

public class Prog3 {
    public static void main(String[] args) {
        String str = "abcddttfrew";
        System.out.println("Largest sub-string with unique characters: "+getLonSubStringWithKUniqueCharacters(str));
    }

    private static int getLonSubStringWithKUniqueCharacters(String str) {
        int maxSubLen = 0;
        int i=0,j=0,n=str.length();
        HashMap<Character,Boolean> h = new HashMap<>();

        while(j<n) {
            if (h.get(str.charAt(j)) == null) {
                h.put(str.charAt(j), true);
                if (j - i + 1 > maxSubLen)
                    maxSubLen = j - i + 1;
                j++;
            } else if(h.get(str.charAt(j)) != null){
                //removing the occurrence of the previous occurrences of character which is in j pos by removing ith pos characters one by obe
                while (h.get(str.charAt(j)) != null) {
                    h.remove(str.charAt(i));
                    i++;
                }
                //now we have removed the previous occurrence of the character ,
                // we add the character at j since already removed it's prev occurrence
                h.put(str.charAt(j), true);
                if (j - i + 1 > maxSubLen)
                    maxSubLen = j - i + 1;
                j++;
            }
        }
        return maxSubLen;
    }
}
