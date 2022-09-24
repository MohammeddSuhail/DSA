package _5_Binary_Tree;
//check: https://www.programiz.com/dsa
/*
1. Full Binary Tree
A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.


2. Perfect Binary Tree
A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes
and all the leaf nodes are at the same level.


3. Complete Binary Tree
A complete binary tree is just like a full binary tree, but with two major differences

Every level must be completely filled
All the leaf elements must lean towards the left.
The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.


4.Balanced Binary Tree
Also referred to as a height-balanced binary tree, is defined as
a binary tree in which the height of the left and right subtree of any node differ by not more than 1.

 */

public class _2_Bin_Tree_Types {
    public static void main(String args[]) {
        BinTree tree = new BinTree();
        tree.root = new Node1(1);
        tree.root.leftChild = new Node1(2);
        tree.root.rightChild = new Node1(10);
        tree.root.leftChild.leftChild = new Node1(4);
        tree.root.leftChild.rightChild = new Node1(5);
        tree.root.rightChild.leftChild = new Node1(6);
        tree.root.rightChild.rightChild = new Node1(7);


        //1. Full Binary Tree
        if (tree.isFullBinaryTree(tree.root))
            System.out.println("The tree is a full binary tree");
        else
            System.out.println("The tree is not a full binary tree");




        //2. Perfect Binary Tree

        int d = tree.depth(tree.root);
        if (tree.is_perfect(tree.root, d, 0))
            System.out.println("The tree is a perfect binary tree");
        else
            System.out.println("The tree is not a perfect binary tree");





        //3. Complete Binary Tree
        int node_count = tree.countNumNodes(tree.root);
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");

    }
}


// Checking if a binary tree is a full binary tree in Java

class Node1 {
    int data;
    Node1 leftChild, rightChild;

    Node1(int item) {
        data = item;
        leftChild = rightChild = null;
    }
}

class BinTree {
    Node1 root;

    //1. Full Binary Tree
    // Check for Full Binary Tree
    boolean isFullBinaryTree(Node1 node) {

        // Checking tree emptiness
        if (node == null)
            return true;

        // Checking the children
        if (node.leftChild == null && node.rightChild == null)
            return true;

        if ((node.leftChild != null) && (node.rightChild != null))
            return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));

        //if one of them is null
        return false;
    }



    //2. Perfect Binary Tree

    // Calculate the depth
    int depth(Node1 node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.leftChild;
        }
        return d;
    }

    // Check if the tree is perfect binary tree
    boolean is_perfect(Node1 root, int d, int level) {

        // Check if the tree is empty
        if (root == null)
            return true;

        // If for children
        if (root.leftChild == null && root.rightChild == null)
            return (d == level + 1);

        if (root.leftChild == null || root.rightChild == null)
            return false;

        //both the children are not null
        return is_perfect(root.leftChild, d, level + 1) && is_perfect(root.rightChild, d, level + 1);
    }




    //3. Complete Binary Tree

    // Count the number of nodes
    int countNumNodes(Node1 root) {
        if (root == null)
            return 0;
        return (1 + countNumNodes(root.leftChild) + countNumNodes(root.rightChild));
    }

    // Check for complete binary tree
    boolean checkComplete(Node1 root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (checkComplete(root.leftChild, 2 * index + 1, numberNodes)
                && checkComplete(root.rightChild, 2 * index + 2, numberNodes));
    }

}
