package _2_SlidingWindow.VariableWindow;

//longest sub-string with k unique characters

import java.util.HashMap;

public class Prog2 {
    public static void main(String[] args) {
        String str = "12322";
        int k = 2; //2 unique characters
        System.out.println("longest sub-string with k unique characters "+getLonSubStringWith_K_UniqueCharacters(str,k));
    }

    private static int getLonSubStringWith_K_UniqueCharacters(String str, int k) {
        int maxSubLen = 0;
        int i=0,j=0,n=str.length();
        HashMap<Character,Integer> h = new HashMap<>();

        while(j<n){
            if(h.get(str.charAt(j))==null){
                h.put(str.charAt(j),1);
            }else{
                int c = h.get(str.charAt(j));
                h.put(str.charAt(j),++c);
            }

            if( h.size() < k){
                j++;
            }else if( h.size() == k) {
                if (j - i + 1 > maxSubLen) {
                    maxSubLen = j - i + 1;
                }
                j++;
            }else if( h.size() > k) {
                while (h.size() > k) {
                    if ( h.get(str.charAt(i)) == 1) {
                        h.remove(str.charAt(i));
                    } else if (h.get(str.charAt(i)) > 1) {
                        int c = h.get(str.charAt(i));
                        h.put(str.charAt(i), c-1);
                    }
                    i++;
                }
                //now h.size==k
                if( h.size() == k) {
                    if (j - i + 1 > maxSubLen) {
                        maxSubLen = j - i + 1;
                    }
                }
                j++;
            }
        }

        return maxSubLen;
    }
}
