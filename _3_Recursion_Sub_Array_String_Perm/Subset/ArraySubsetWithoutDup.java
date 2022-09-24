package _3_Recursion_Sub_Array_String_Perm.Subset;

import java.util.*;

//one way
public class ArraySubsetWithoutDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //time:  (2^n)*log(n) ,space: (2^n)*n  ,n is the max length of each subset
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();

        fun(nums, 0, ds, res);

        for (List< Integer> it: res) {
            ans.add(it);
        }
        return ans;
    }

    public static void fun(int[] nums, int index, List<Integer> ds, HashSet<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> a = new ArrayList<>(ds);
            Collections.sort(a);  //because set won't know whether [1,2,1] and [1,1,2] are same
            res.add(a);
            return;
        }

        ds.add(nums[index]);
        fun(nums, index + 1, ds, res);

        ds.remove(ds.size() - 1);
        fun(nums, index + 1, ds, res);
    }

}

//other way
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //sort the ele's,so that all same ele are side by side
        Arrays.sort(nums);
        subsetNoDup(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
    //basically include all the ele's(even dup's) while left recursion calls, but we include the cur ele as well as
    //dup ele while right recursion call so that dup subset is avoided
    public static void subsetNoDup(int[] nums, int index, List<Integer> ds, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> a = new ArrayList<>(ds);
            ans.add(a);
            return;
        }

        //all subsets that include nums[i]
        ds.add(nums[index]);
        subsetNoDup(nums, index + 1, ds, ans);
        ds.remove(ds.size() - 1);

        //all subsets that doesn't include nums[i]
        //we have included nums[i] in above steps, now we don't need to include it, but if the next index ele
        //nums[index+1] is also same as nums[index] then we need to ignore it
        //basically reaching last index with current duplice, i.e, reaching index just before new ele
        while(index+1 < nums.length && nums[index] == nums[index+1])
            index++;

        subsetNoDup(nums, index + 1, ds, ans);
    }
}