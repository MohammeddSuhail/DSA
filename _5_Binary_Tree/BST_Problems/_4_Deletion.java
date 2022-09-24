package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/delete-node-in-a-bst/
 */

public class _4_Deletion {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteRec(root, key);
    }

    TreeNode deleteRec(TreeNode root, int key) {
        // Return if the tree is empty
        if (root == null)
            return null;

        // Find the node to be deleted
        if (key < root.val)
            root.left = deleteRec(root.left, key);
        else if (key > root.val)
            root.right = deleteRec(root.right, key);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor(i.e, the smallest element of right subtree) in position of the node to be deleted
            root.val = minValue(root.right);

            // Delete the inorder successor, it will be in right subtree so root.right in below line
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    // Find the inorder successor ,i.e, the smallest element of right subtree
    int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }
}
