package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

public class _4_Insertion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val < root.val)
            root.left = insertIntoBST(root.left,val);

        if(val >root.val)
            root.right = insertIntoBST(root.right,val);

        return root;
    }
}
