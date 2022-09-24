package _3_Recursion_Sub_Array_String_Perm.Subset;

import java.util.ArrayList;

public class Array_Subset {
    public static void main(String[] args) {
        int[] arr = {3,1,2};

        System.out.println("here we add ele and then not add");
        ArrayList<Integer> ds = new ArrayList<Integer>();
        subSet(0,arr,ds);

        System.out.println("here we don't add ele and then add");
        ArrayList<Integer> ds2 = new ArrayList<Integer>();
        subSetss(0,arr,ds2);


        System.out.println("storing the subsequences:");

        ArrayList<Integer> ds1 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        subSets(0,arr,ds1,ans);
        System.out.println(ans);
    }

    static void subSet(int index,int[] arr,ArrayList<Integer> ds){
        if(index == arr.length){
            System.out.println(ds);
            return;
        }

        ds.add(arr[index]);     //add ele
        subSet(index+1, arr, ds);  //take ele to be included in the subsequence
        ds.remove(ds.size()-1);    //rem added ele so that we can have subset without this ele

        subSet(index+1, arr, ds);  //don't take ele to be included in the subsequence
    }

    static void subSetss(int index,int[] arr,ArrayList<Integer> ds2){
        if(index == arr.length){
            System.out.println(ds2);
            return;
        }

        subSetss(index+1, arr, ds2);

        ds2.add(arr[index]);
        subSetss(index+1, arr, ds2);
        ds2.remove(ds2.size()-1);
    }

    static void subSets(int index,int[] arr,ArrayList<Integer> ds1,ArrayList<ArrayList<Integer>> ans){
        if(index == arr.length){
            //creating new list because ds1 is pass by reference
            ans.add(new ArrayList<>(ds1));
            return;
        }

        ds1.add(arr[index]);
        subSets(index+1, arr, ds1,ans);
        ds1.remove(ds1.size()-1);

        subSets(index+1, arr, ds1,ans);
    }

}
