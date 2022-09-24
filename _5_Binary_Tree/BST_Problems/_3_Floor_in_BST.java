package _5_Binary_Tree.BST_Problems;

/*
    https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0
 */

public class _3_Floor_in_BST {
    public static int floorInBST(TreeNode root, int x) {
        // finding val<=x which is nearer to x
        int floor=-1;
        while(root != null){
            if(root.val == x)
                return x;

            if(root.val > x){
                root = root.left;
            }else{
                //root.data is less than x and if we keep on moving rightt, diff will reduce
                floor = root.val; //possible ans
                root = root.right;
            }
        }
        return floor;
    }
}
