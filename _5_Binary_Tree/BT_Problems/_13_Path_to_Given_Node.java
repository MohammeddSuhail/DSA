package _5_Binary_Tree.BT_Problems;

/*
    https://www.interviewbit.com/problems/path-to-given-node/
 */

import java.util.*;
import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _13_Path_to_Given_Node {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();

        traverse(A,B,ans);

        return ans;
    }

    boolean traverse(TreeNode root, int B, ArrayList<Integer> ans){
        if(root == null)
            return false;

        ans.add(root.val);

        if(root.val == B)
            return true;

        if(traverse(root.left, B, ans) || traverse(root.right, B, ans)){
            return true;
        }else{
            ans.remove(ans.size()-1);
            return false;
        }
    }
}
