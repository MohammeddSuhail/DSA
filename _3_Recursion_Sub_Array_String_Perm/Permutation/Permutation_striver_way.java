package _3_Recursion_Sub_Array_String_Perm.Permutation;

import java.util.*;

public class Permutation_striver_way {
    public List<List<Integer>> permute(int[] nums) {
        //complexity: time: 2!*n, space: n+n+2!
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];   //for keeping track what is picked

        permutation(nums, new ArrayList<>(), freq, ans);

        return ans;
    }

    void permutation(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        //each time u have <=n options to choose, if picked ele pick it
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                ds.add(nums[i]);
                freq[i] = true;
                permutation(nums, ds, freq, ans);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}



//other way: using swapping
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Time Complexity: O(N! X N), Space Complexity: O(1) excluding ans and auxillary space

        List<List<Integer>> ans = new ArrayList<>();

        permutation(0, nums, ans);

        return ans;
    }

    void permutation(int index, int[] nums,List<List<Integer>> ans){
        if(index == nums.length){ //when index to be swapped is n
            List<Integer> a =  new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                a.add(nums[i]);
            }
            ans.add(a);
            return;
        }

        //the current_index is swapped with every other_index>=index
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            permutation(index+1,nums,ans);
            swap(nums,index,i);
        }
    }

    void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

