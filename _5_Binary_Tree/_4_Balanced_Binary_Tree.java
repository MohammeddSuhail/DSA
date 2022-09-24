package _5_Binary_Tree;

/*
    https://leetcode.com/problems/balanced-binary-tree/

    Time Complexity: O(N)
    Space Complexity: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)
 */

public class _4_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }
    int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight (root.left);
        if(leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight (root.right);
        if(rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    class TreeNode {
      int val;
      TreeNode left, right;
      TreeNode(int val) {
          this.val = val;
      }
    }
}
