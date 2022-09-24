package _5_Binary_Tree.BST_Problems;

/*
    https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0
 */

public class _2_Ceil_in_BST {
    public  static int findCeil(TreeNode root, int x) {

        // finding val>=x which is nearer to x
        int ceil=-1;
        while(root != null){
            if(root.val == x)
                return x;

            if(root.val < x){
                root = root.right;
            }else{
                //root.data is greater than x and if we keep on moving left, diff will reduce
                ceil = root.val; //possible ans
                root = root.left;
            }
        }
        return ceil;
    }
}
