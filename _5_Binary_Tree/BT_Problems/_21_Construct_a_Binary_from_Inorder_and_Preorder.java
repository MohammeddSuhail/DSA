package _5_Binary_Tree.BT_Problems;
/*
    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    First ele of pre-order will tell the root
    left and right of that node is found using in-order

    No of nodes left to node, leftEles =  inRoot-inStart

    so left:
    inStart to inRoot-1    and    preStart+1 to preStart+leftEles

    right:
    inRoot+1 to inEnd      and    preStart+leftEles+1 to preEnd
 */

import java.util.*;

public class _21_Construct_a_Binary_from_Inorder_and_Preorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //put all inorder ele-index to hashmap
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return buildT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    TreeNode buildT(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(preStart>preEnd || inStart>inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val); //finding the index of root.val using hashmap
        int leftEles = inRoot-inStart;    //no of eles left of root

        //                            next     these many on left half
        root.left = buildT(preorder, preStart+1, preStart+leftEles, inorder, inStart, inRoot-1, inMap);
        root.right = buildT(preorder, preStart+leftEles+1, preEnd, inorder, inRoot+1, inEnd, inMap);
        //                              right half start

        return root;
    }
}
