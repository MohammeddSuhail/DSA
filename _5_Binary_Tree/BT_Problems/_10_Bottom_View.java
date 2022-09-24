package _5_Binary_Tree.BT_Problems;

/*
    https://www.codingninjas.com/codestudio/problems/top-view-of-the-tree_799401?source=youtube&amp;campaign=Striver_Tree_Videos&amp;utm_source=youtube&amp;utm_medium=affiliate&amp;utm_campaign=Striver_Tree_Videos
 */

import java.util.*;


public class _10_Bottom_View {
    public static ArrayList<Integer> bottomView(TreeNode root) {
        TreeMap< Integer, Integer> map = new TreeMap < > ();
        Queue<Node> q = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;

        q.add(new Node(root,0));
        while(!q.isEmpty()){
            Node temp = q.remove();

            int vert = temp.vert;
            map.put(vert, temp.node.val);

            if(temp.node.left != null)
                q.add(new Node(temp.node.left, vert-1));

            if(temp.node.right != null)
                q.add(new Node(temp.node.right, vert+1));
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
