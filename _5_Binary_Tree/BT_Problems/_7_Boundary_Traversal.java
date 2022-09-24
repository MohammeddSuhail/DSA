package _5_Binary_Tree.BT_Problems;

/*
    https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0

    Time Complexity: O(N).
    Reason: The time complexity will be O(H) + O(H) + O(N) which is ≈ O(N)

    Space Complexity: O(N)
    Reason: Space is needed for the recursion stack while adding leaves. In the worst case (skewed tree), space complexity can be O(N).

    1. add root.val to answer
    2. add left boundary except leaf nodes and root
    3. add leaf nodes
    4. add reverse (right boundary except leaf nodes and root)
 */


import java.util.*;

public class _7_Boundary_Traversal {
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();

        if(root.right == null && root.left == null){
            ans.add(root.val);
            return ans;
        }

        //root ele
        ans.add(root.val);

        //left boundary except leaf nodes and root
        leftBounExceptLeaf(root.left,ans);

        //adding leaf nodes
        leafNodes(root,ans);

        //right boundary except leaf nodes and root
        ArrayList<Integer> rightBoun = new ArrayList<>();
        rightBounExceptLeaf(root.right,rightBoun);
        //add reverse right boundary
        for(int i = rightBoun.size()-1;i>=0;i--){
            ans.add(rightBoun.get(i));
        }

        return ans;
    }

    static void leftBounExceptLeaf(TreeNode root, ArrayList<Integer> ans){
        if(root == null)
            return;

        //for not including leaf nodes
        if(root.left == null && root.right == null)
            return;

        ans.add(root.val);

        if(root.left != null)
            leftBounExceptLeaf(root.left, ans);
        else
            leftBounExceptLeaf(root.right, ans);
    }

    static void leafNodes(TreeNode root, ArrayList<Integer> ans){
        if(root == null)
            return;

        //adding leaf nodes
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    static void rightBounExceptLeaf(TreeNode root, ArrayList<Integer> rightBoun){
        if(root == null)
            return;

        //for not including leaf nodes
        if(root.left == null && root.right == null)
            return;

        rightBoun.add(root.val);

        if(root.right != null)
            rightBounExceptLeaf(root.right, rightBoun);
        else
            rightBounExceptLeaf(root.left, rightBoun);
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
