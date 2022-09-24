package Problems;

/*
    https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1?page=3&category[]=Arrays&category[]=Strings&sortBy=submissions
 */

public class _2_Reverse_words {
    String reverseWords(String S)
    {
        // code here
        int n = S.length();

        //check fo S: "hi"
        boolean present = false;
        for(int i=0;i<n;i++){
            if(S.charAt(i) == '.')
                present = true;
        }
        if(!present)
            return S;

        String ans = "", s="";

        for(int i=0;i<n;i++){
            if(S.charAt(i) != '.'){
                s += S.charAt(i);
            }else{
                if(ans.length() == 0)
                    ans = s;
                else
                    ans = s + "." + ans;
                s = "";
            }
        }

        ans = s + "." + ans;

        return ans;
    }
}
