package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */

import java.util.HashSet;

public class _9_Pair_With_Sum {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> h = new HashSet<>();

        addEles(root,h);

        return fTarget(root,k,h);
    }

    void addEles(TreeNode root, HashSet<Integer> h){
        if(root != null){
            h.add(root.val);
            addEles(root.left,h);
            addEles(root.right,h);
        }
    }

    boolean fTarget(TreeNode root, int k, HashSet<Integer> h){
        if(root == null)
            return false;

        int required = k - root.val;

        if(root.val != required && h.contains(required)) //root.val != required ,check for: ele needed is is cur ele itself, then skip
            return true;

        return fTarget(root.left, k, h) || fTarget(root.right, k, h);
    }
}
