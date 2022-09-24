package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/symmetric-tree/
 */

import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _12_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        return isSymm(root.left,root.right);
    }

    boolean isSymm(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        //if only one is null
        if(left == null || right == null){
            return false;
        }

        if(left.val == right.val) //if same then check others
            return isSymm(left.left, right.right) && isSymm(left.right, right.left);
        else
            return false; //if vals not same just return false
    }
}
