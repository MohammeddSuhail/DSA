package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

public class _7_Longest_Common_Ancestor_Of_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        int curVal = root.val;

        //both p and q in left
        if(p.val < curVal && q.val < curVal)
            return lowestCommonAncestor(root.left, p, q);

        //both p and q in right
        if(p.val > curVal && q.val > curVal)
            return lowestCommonAncestor(root.right, p, q);

        //if p and q are on different side of cur, then cur is the LCA (i.e, where split happens)
        //if cur is itself p or q, then above condition will be false, because both ele neither on right/left
        //so LCA is cur itself
        return root;
    }
}
