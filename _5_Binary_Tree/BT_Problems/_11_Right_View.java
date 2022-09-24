package _5_Binary_Tree.BT_Problems;
/*
    https://leetcode.com/problems/binary-tree-right-side-view/
 */

import java.util.*;

public class _11_Right_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        rightView(root, ans, 1);
        return ans;
    }

    public void rightView(TreeNode curr, List<Integer> ans, int currDepth){
        if(curr == null){
            return;
        }
        if(ans.size() < currDepth){
            ans.add(curr.val);
        }

        rightView(curr.right, ans, currDepth + 1);
        rightView(curr.left, ans, currDepth + 1);

    }

    class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int data) {
            this.val = data;
        }
    }
}
