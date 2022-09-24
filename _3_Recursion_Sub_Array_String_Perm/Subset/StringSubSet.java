package _3_Recursion_Sub_Array_String_Perm.Subset;

import java.util.ArrayList;

public class StringSubSet {
    public static void main(String[] args) {

        //printing subset of a string
        //printSubset("","abc");

        //storing the subset of the string in an ArrayList
        //ArrayList<String> arrayList = new ArrayList<>();
        //SubsetAsList("","abc",arrayList);
        //System.out.println(arrayList);

        //storing the subset of the string in an ArrayList and returning it
        ArrayList<String> list = subSetRetList("","abc");
        System.out.println(list);


    }

    //printing subset of a string
    private static void printSubset(String p,String up) {
        if (up.length()==0){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        printSubset(p+ch , up.substring(1));
        printSubset(p,up.substring(1));
    }



    //storing the subset of the string in an ArrayList
    private static void SubsetAsList(String p, String up, ArrayList<String> arrayList) {
        if (up.isEmpty()){
            arrayList.add(p);
            return;
        }

        char ch = up.charAt(0);

        SubsetAsList(p+ch , up.substring(1),arrayList);
        SubsetAsList(p,up.substring(1),arrayList);
    }



    private static ArrayList<String> subSetRetList(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(p);
            return arrayList;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSetRetList(p+ch , up.substring(1));
        ArrayList<String> right = subSetRetList(p , up.substring(1));

        left.addAll(right);
        return left;
    }


}
