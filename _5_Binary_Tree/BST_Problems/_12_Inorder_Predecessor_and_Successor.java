package _5_Binary_Tree.BST_Problems;

public class _12_Inorder_Predecessor_and_Successor {
    static void findPreSuc(TreeNode root, int key, int pre, int suc) {

        // Base case
        if (root == null)
            return;

        // If key is present at root
        if (root.val == key) {

            // The maximum value in left
            // subtree is predecessor
            if (root.left != null) {
                TreeNode tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp.val;
            }

            // The minimum value in
            // right subtree is successor
            if (root.right != null) {
                TreeNode tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp.val;
            }
            return;
        }
    }
}
