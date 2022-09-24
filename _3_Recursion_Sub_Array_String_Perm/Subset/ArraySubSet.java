package _3_Recursion_Sub_Array_String_Perm.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySubSet {
    public static void main(String[] args) {
        //there will be 2^n subsets
        int[] arr = {1,2,3};

        ArrayList<ArrayList<Integer>> ans = subSet(arr);
        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }


        System.out.println();
        int[] a ={1,2,2};
        List<List<Integer>> ans2= subsetDuplicate(a);
        for (List<Integer> list: ans2) {
            System.out.println(list);
        }

        System.out.println("striver:");
        ArrayList<Integer> ds = new ArrayList<Integer>();

        subSets(0,new int[]{3,2,1},ds);

    }

    static void subSets(int index,int[] arr,ArrayList<Integer> ds){
        if(index == arr.length){
            System.out.println(ds);
            return;
        }

        ds.add(arr[index]);
        subSets(index+1, arr, ds);
        ds.remove(ds.size()-1);

        subSets(index+1, arr, ds);
    }

    //using loops ,noo recursion
    static ArrayList<ArrayList<Integer>> subSet(int[] arr){

        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        //at first there is a null list so
        outer.add(new ArrayList<Integer>());

        for (int num : arr) {
            int n = outer.size(); //the size of outer keeps changing after addition each ele ,then for next ele outer.size() no.of new list will be more
            //each time new ele is added to copy of each (i.e, inner) list present in outer
            for (int i = 0; i < n; i++) {
                //making a copy of the list at ith pos of outer list
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);       //adding the num to copy of each (i.e, inner) of the list present in outer (through iteration)
                outer.add(inner);     //adding the new list to outer
            }
        }

        return outer;
    }



    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same, s = e + 1
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

}
