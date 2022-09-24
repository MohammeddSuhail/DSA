package _5_Binary_Tree.BT_Problems;

/*
    Time Complexity: O(N).
    Reason: We are doing a tree traversal.

    Space Complexity: O(N)
    Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).
 */

public class _5_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }

    boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;

        if(p == null || q == null || p.val != q.val)
            return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
