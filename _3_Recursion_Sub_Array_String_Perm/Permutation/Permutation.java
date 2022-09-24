package _3_Recursion_Sub_Array_String_Perm.Permutation;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        //there will be n! permutation

        PrintPermutation("","abc");

        ArrayList<String> list = new ArrayList<>();
        Permu("","abc",list);
        System.out.println(list);

        ArrayList<String> list2 = Permuta("","abc");
        System.out.println(list2);

    }


    static void PrintPermutation(String p , String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char c = up.charAt(0);

        //taking c and placing at diff positions in String p , there will be p.length() + 1 no of places to place the char c
        for (int i = 0; i <=p.length() ; i++) {
            String s  = p.substring(0,i);
            String e = p.substring(i,p.length());

            PrintPermutation(s+c+e , up.substring(1));
        }
    }




    //storing the permutation of the string in an ArrayList
    static void Permu(String p , String up , ArrayList<String> list){

        if(up.isEmpty()){
            list.add(p);
            return;
        }

        char c = up.charAt(0);

        //taking c and placing at diff positions in String p , there will be p.length() + 1 no of places to place the char c
        for (int i = 0; i <=p.length() ; i++) {
            String s  = p.substring(0,i);
            String e = p.substring(i,p.length());

            Permu(s+c+e , up.substring(1) , list);
        }
    }




    //storing the permutation of the string in an ArrayList without passing in argument
    static ArrayList<String> Permuta(String p , String up ){

        if(up.isEmpty()){
            ArrayList<String> newList = new ArrayList<>();
            newList.add(p);
            return newList;
        }

        char c = up.charAt(0);

        //local to ths call
        ArrayList<String> ans = new ArrayList<>();

        //taking c and placing at diff positions in String p , there will be p.length() + 1 no of places to place the char c
        for (int i = 0; i <=p.length() ; i++) {
            String s  = p.substring(0,i);
            String e = p.substring(i,p.length());

            ans.addAll(Permuta(s+c+e , up.substring(1)));
        }

        return ans;
    }
}
