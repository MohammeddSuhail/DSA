package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _14_Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        one way:
        find path from root to p
        find path from root to q
        then find Lowest Common Ancestor
        */

        return loComAnc(root,p,q);
    }

    TreeNode loComAnc(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;

        if(root == p)
            return p;

        if(root == q)
            return q;

        TreeNode left = loComAnc(root.left, p, q);
        TreeNode right = loComAnc(root.right, p, q);

        if(left == null && right == null)//if p or q not found in subtree
            return null;
        else if(left != null && right != null) //if both ans is present in subtree
            return root; //answer
        else if(left == null)   //if one of p or q found
            return right;
        else           //if(right == null), if one of p or q found
            return left;
    }
}
