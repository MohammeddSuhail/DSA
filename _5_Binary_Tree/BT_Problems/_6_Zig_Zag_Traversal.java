package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    Time Complexity: O(N)
    Space Complexity: O(N)
 */

import java.util.*;
import _5_Binary_Tree.BT_Problems._2_LeftView_Of_Binary_Tree.Node;

public class _6_Zig_Zag_Traversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        boolean rightDir = true;
        q.add(root);
        while(!q.isEmpty()){
            int noOfNodeInThisLevel = q.size();
            List<Integer> curLevel = new ArrayList<>();

            for(int i=0; i<noOfNodeInThisLevel; i++){
                Node node = q.remove();

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);

                if(rightDir) //->
                    curLevel.add(node.val); //adding to end
                else //<-
                    curLevel.add(0, node.val); //adding to front
            }
            ans.add(curLevel);

            if(rightDir)
                rightDir = false;
            else
                rightDir = true;
        }

        return ans;
    }
}
