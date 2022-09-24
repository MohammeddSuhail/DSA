package _5_Binary_Tree.BT_Problems;

import java.util.ArrayList;

public class _2_LeftView_Of_Binary_Tree {
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();

        preOrder(root, 1, ans);

        return ans;
    }

    //for right view just call right rec call first
    void preOrder(Node node, int depth, ArrayList<Integer> ans){
        if(node != null){
            if(ans.size() < depth)   //adding only first ele from each layer
                ans.add(node.val);
            preOrder(node.left, depth+1, ans);
            preOrder(node.right, depth+1, ans);
        }
    }

    class Node{
        int val;
        Node left,right;

        public Node(int data) {
            this.val = data;
        }
    }
}
