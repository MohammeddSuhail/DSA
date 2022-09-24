package _3_Recursion_Sub_Array_String_Perm.Subset.Problems;

import java.util.ArrayList;
import java.util.List;

public class CombSum {
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[] {2,3,6,7} , 7);

        System.out.println(list);
//        for (List<Integer> l : list) {
//            System.out.println(l);
//        }
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = subSet(candidates);
        return list;
    }

    static List<List<Integer>> subSet(int[] arr){

        List<List<Integer>> outer = new ArrayList<>();

        //at first there is a null list so
        outer.add(new ArrayList<Integer>());

        for (int num : arr) {
            int n = outer.size();
            //each time new ele is added to each list present in outer
            for (int i = 0; i < n; i++) {
                //making a copy of the list at ith pos of outer list
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);       //adding the num to each of the list present in outer (through iteration)
                outer.add(inner);     //adding the new list to outer
            }
        }

        return outer;
    }

    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }
}
