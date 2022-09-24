package _5_Binary_Tree.BT_Problems;

/*
    1.
    https://www.codingninjas.com/codestudio/problems/level-order-traversal_796002?source=youtube&amp;campaign=Striver_Tree_Videos&amp;utm_source=youtube&amp;utm_medium=affiliate&amp;utm_campaign=Striver_Tree_Videos&leftPanelTab=0

    Time Complexity: O(N)
    Space Complexity: O(N)

    2.
    https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

import _5_Binary_Tree.BT_Problems._2_LeftView_Of_Binary_Tree.Node;
import java.util.*;

public class _1_Level_Order_Traversal {
    //1.
    public static ArrayList<Integer> getLevelOrder(Node root) {
        //Your code goes here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if(root == null)
            return ans;

        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            ans.add(node.val);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }

        return ans;
    }



    //2.
    //returning List<List<Integer>>
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int noOfNodeInThisLevel = q.size();
            List<Integer> curLevel = new ArrayList<>();

            for(int i=0; i<noOfNodeInThisLevel; i++){
                Node node = q.remove();

                curLevel.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            ans.add(curLevel);
        }

        return ans;
    }
}
