package _5_Binary_Tree.BT_Problems;

/*
    u can do it using extra space easily

    but here we did it without any extra space

                 1
           2          5
        3     4           6
                        7

        => 1 2 3 4 5 6 7

        4 should know it had to connect to 5 , right hand side mst b computed first

        we reach 7, and we make its
        right as prev
        left as null
        prev = node , i,e in this case 7

        then 6 makes its
        right as prev, i,e, i this case 7
        left as null
        prev = node, i,e in this case 7
 */

import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _19_Flatten_Binary_tree {
    TreeNode prev = null;
    public void flatten(TreeNode  root) {
        if (root == null) return;

        flatten(root . right);
        flatten(root . left);

        root . right = prev;
        root . left = null;
        prev = root;
    }
}
