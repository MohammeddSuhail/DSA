package _5_Binary_Tree.BST_Problems;

/*
    In-Order of BST is always sorted
 */

public class _5_Kth_largest_smallest_element {
    static int c, ans;
    public int kthSmallest(TreeNode root, int k) {
        c=k;

        inOrder(root);

        /*
            for kth largest find (N-k+1)

            or

            kth element when traversing in right , root, left fashion
         */

        return ans;
    }

    void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);

            c--;
            if(c==0){
                ans = root.val;
                return;
            }

            inOrder(root.right);
        }
    }
}
