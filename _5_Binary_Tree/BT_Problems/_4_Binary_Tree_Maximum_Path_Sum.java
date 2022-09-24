package _5_Binary_Tree.BT_Problems;
/*
    https://leetcode.com/problems/binary-tree-maximum-path-sum/

    Time Complexity: O(N).
    Reason: We are doing a tree traversal.

    Space Complexity: O(N)
    Reason: Space is needed for the recursion stack. In the worst case (skewed tree), space complexity can be O(N).
 */

public class _4_Binary_Tree_Maximum_Path_Sum {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;

        maxPathS(root,maxSum);

        return maxSum[0];
    }

    int maxPathS(TreeNode root, int[] maxSum){
        if(root == null)
            return 0;

        int lSum = Math.max(0, maxPathS(root.left,maxSum)); //don't include if further sum is -ve
        int rSum = Math.max(0, maxPathS(root.right,maxSum));//don't include if further sum is -ve

        int curNodeThroughSum = root.val + lSum + rSum;
        maxSum[0] = Math.max(maxSum[0], curNodeThroughSum);

        return Math.max(root.val + lSum ,root.val + rSum);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
