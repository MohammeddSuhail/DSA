package _3_Recursion_Sub_Array_String_Perm;

public class KthBitInNth {

    public static void main(String[] args) {
        System.out.println(findKthBit(20,1));

        String s="dd";
    }


    static char findKthBit(int n, int k) {
        String str = theStringIs(n ,"");

        System.out.println(str);

        return str.charAt(k-1);
    }

    static String theStringIs(int n , String str) {
        if(n==0)
            return str;
        if(n==1)
            return "0";

        return theStringIs(n-1,str) + "1" + invert(theStringIs(n-1,str));

    }

    static String  invert(String s){
        String inv = "";

        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == '0'){
                inv+="1";
            }else{
                inv+="0";
            }
        }

        return inv;
    }
}
