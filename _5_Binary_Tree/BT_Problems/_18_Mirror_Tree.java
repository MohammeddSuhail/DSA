package _5_Binary_Tree.BT_Problems;

/*
    https://practice.geeksforgeeks.org/problems/mirror-tree/1
 */

import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _18_Mirror_Tree {

    TreeNode mir(TreeNode node)
    {
        if (node == null)
            return null;

        /* do the subtrees */
        TreeNode left = mir(node.left);
        TreeNode right = mir(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }
}
