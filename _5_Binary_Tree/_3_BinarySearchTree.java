package _5_Binary_Tree;

/* Binary Search Tree operations in Java
    https://www.programiz.com/dsa/binary-search-tree
    In BST for every node,
    every val on left < node.val  and every val right is > node.val
 */

public class _3_BinarySearchTree {
    Node root;

    _3_BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    // Insert key in the tree
    Node insertKey(Node root, int key) {
        // Return a new node if the tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Traverse to the right place and insert the node
        if (key < root.val)
            root.left = insertKey(root.left, key);
        else if (key > root.val)
            root.right = insertKey(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    // Inorder Traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " -> ");
            inorderRec(root.right);
        }
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
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
            // Place the inorder successor in position of the node to be deleted
            root.val = minValue(root.right);

            // Delete the inorder successor, it will be in right subtree so root.right in below line
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        _3_BinarySearchTree tree = new _3_BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }



    class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }
}