package _5_Binary_Tree.BT_Problems;

/*
    Preorder inorder postorder in a single traversal
 */

import java.util.*;
import _5_Binary_Tree.BT_Problems._3_Diameter_of_Binary_Tree.TreeNode;

public class _15_Pre_In_Post_In_Single_Traversal {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        traverse(root, pre, in, post);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }

    static void traverse(TreeNode root, List<Integer> pre , List<Integer> in ,List<Integer> post){
        if(root == null)
            return;

        pre.add(root.val);
        traverse(root.left, pre, in, post);
        in.add(root.val);
        traverse(root.right, pre, in, post);
        post.add(root.val);
    }
}
