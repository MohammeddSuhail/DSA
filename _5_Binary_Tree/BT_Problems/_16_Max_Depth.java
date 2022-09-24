package _5_Binary_Tree.BT_Problems;

import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _16_Max_Depth {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
