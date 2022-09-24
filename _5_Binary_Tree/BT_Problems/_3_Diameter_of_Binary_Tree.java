package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class _3_Diameter_of_Binary_Tree {
    public int diameterOfBinaryTreeOneWay(TreeNode root) {
        return depthAdd(root);
    }

    int depthAdd(TreeNode root){
        if(root == null)
            return 0;

        //at each index height(left)+height(right)
        int nowDia = height(root.left) + height(root.right);  //dia considering path through cur node

        int leftDia = depthAdd(root.left);   //dia considering path through left node
        int rightDia = depthAdd(root.right); //dia considering path through right node

        return Math.max(nowDia, Math.max(leftDia,rightDia));
    }

    int height(TreeNode root){
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left),height(root.right));
    }


    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }





    //Other Way

    public int diameterOfBinaryTree(TreeNode root) {
        //took array of len 1, instead of variable because array is pass by referece
        int[] maxDia = new int[1];

        height(root,maxDia);

        return maxDia[0];
    }

    int height(TreeNode node, int[] maxDia) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, maxDia);
        int rh = height(node.right, maxDia);

        int curDia = lh + rh;
        maxDia[0] = Math.max(maxDia[0], curDia);

        return Math.max(1+lh, 1+rh);
    }
}
