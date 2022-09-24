package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

    one way: O(N^2)
    first take cur ele
    find the ele's less than it and pass it to right recursion call
    rest pass it to right recursion call

    2nd way: O(n*log(n))
    you can find in-order of the bst by sorting pre-order array
    and use in-order and pre-order to construct the array

    3rd way: O(n)
    traverse the pre-order array from start and check if it is less than upperbound bound, if no return null
    or else create node
    for left call set upper bound as node.val
    for right call set upper bound as upper bound of node
 */

public class _11_Construct_BST_from_preorder_traversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPre(new int[1], Integer.MAX_VALUE, preorder);
    }

    TreeNode bstFromPre(int[] index, int upperBound, int[] preorder){
        if(index[0] == preorder.length || preorder[index[0]] > upperBound)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]]);

        index[0]++;
        root.left = bstFromPre(index, root.val, preorder);
        root.right = bstFromPre(index, upperBound, preorder);

        return root;
    }
}
