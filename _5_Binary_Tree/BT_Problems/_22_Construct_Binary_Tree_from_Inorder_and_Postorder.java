package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    Last ele of post-order will tell the root
    left and right of that node is found using in-order

    No of nodes left to node, leftEles =  inRoot-inStart

    so left:
    inStart to inRoot-1    and    postStart to postStart+leftEles-1

    right:
    inRoot+1 to inEnd      and    postStart+leftEles to postEnd-1
 */

import java.util.*;

public class _22_Construct_Binary_Tree_from_Inorder_and_Postorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //put all inorder ele-index to hashmap
        HashMap<Integer, Integer> inMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }

        return buildT(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    TreeNode buildT(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(postStart>postEnd || inStart>inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val); //finding the index of root.val using hashmap
        int leftEles = inRoot-inStart;    //no of eles left of root


        //                           left half will be first leftEles
        root.left = buildT(postorder, postStart, postStart+leftEles-1, inorder, inStart, inRoot-1, inMap);
        root.right = buildT(postorder, postStart+leftEles, postEnd-1, inorder, inRoot+1, inEnd, inMap);
        //                             after leftEles   to  end-1

        return root;
    }
}
