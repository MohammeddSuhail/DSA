package _5_Binary_Tree.BT_Problems;

/*
    https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

    solution:
    Just find the max val in the binary tree
    Then assign to all the leaf nodes
    Then do root.val = root.left.val + root.right.val
 */

public class _20_Check_for_Children_Sum_Property {
    public static void changeTree(TreeNode root) {
        // Write your code here.
        if(root != null){
            int maxVal = maxTraverse(root);
            assign(root,maxVal);
        }
    }

    static int maxTraverse(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max(root.val, Math.max(maxTraverse(root.left), maxTraverse(root.right)));
    }

    static void assign(TreeNode root, int maxVal){
        if(root.left == null && root.right == null){ //if leaf assisn max
            root.val = maxVal;
            return;
        }

        if(root.left != null)
            assign(root.left, maxVal);

        if(root.right != null)
            assign(root.right, maxVal);

        //after assigning the root with maxVal, root.val = left.val + right.val
        int val = 0;

        if(root.left != null)
            val += root.left.val;

        if(root.right != null)
            val += root.right.val;

        root.val = val;
    }
}
