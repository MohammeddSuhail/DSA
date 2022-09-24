package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/search-in-a-binary-search-tree/
 */


public class _1_Search_In_BST {

    //recursive
    public TreeNode searchBSTRec(TreeNode root, int val) {
        if(root == null)
            return null;

        if(root.val == val)
            return root;

        if(val<root.val)
            return searchBSTRec(root.left, val);
        else
            return searchBSTRec(root.right, val);
    }


    //iterative
    public TreeNode searchBSTIterative(TreeNode root, int val) {

        while(root != null && root.val != val){
            if(val<root.val)
                root = root.left;
            else
                root = root.right;
        }

        return root;
    }
}




class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
