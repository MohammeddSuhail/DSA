package _5_Binary_Tree;

import java.util.Scanner;

class Node{
    int val;
    Node lchild,rchild;

    public Node(int val) {
        this.val = val;
    }
}

class BinaryTree {
    static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        Node root = createTree();

        //traversals
        System.out.println("Pre Order");
        preOrder(root);

        System.out.println("In Order");
        inOrder(root);

        System.out.println("Post Order");
        postOrder(root);

        System.out.println("Height of Binary Tree : "+heightOfTree(root));

        System.out.println("Size of Binary Tree : "+size(root));

        System.out.println("Maximum Element of Binary Tree : "+maximum(root));
    }


    //Creation of Binary tree
    static Node createTree(){
        System.out.println("Enter the data: ");
        int val = s.nextInt();

        if(val == -1)
            return null;

        Node root = new Node(val);

        System.out.println("Enter Left Child of "+val+": ");
        root.lchild = createTree();

        System.out.println("Enter Right Child of "+val+": ");
        root.rchild = createTree();

        return root;
    }


    //Traversals

    static void preOrder(Node root){
        if(root != null){
            System.out.println(root.val);
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    static void inOrder(Node root){
        if(root != null){
            inOrder(root.lchild);
            System.out.println(root.val);
            inOrder(root.rchild);
        }
    }

    static void postOrder(Node root){
        if(root != null){
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.println(root.val);
        }
    }



    //Height , Size , Maximum of Binary Tree

    static int heightOfTree(Node root){

        if(root == null)
            return 0;

        return Math.max( heightOfTree(root.lchild), heightOfTree(root.rchild) ) +1 ;
    }

    static int size(Node root){

        if(root == null)
            return 0;

        return size(root.lchild) + size(root.rchild) + 1;
    }

    static int maximum(Node root){

        if(root == null)
            return Integer.MIN_VALUE;

        return Math.max( root.val , Math.max( maximum(root.lchild), maximum(root.rchild) ) );
    }

}
