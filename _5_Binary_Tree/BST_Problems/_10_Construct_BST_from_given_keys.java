package _5_Binary_Tree.BST_Problems;

/*
    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class _10_Construct_BST_from_given_keys {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    TreeNode buildTree(int[] nums, int start, int end){
        if(start>end)
            return null;

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildTree(nums,start,mid-1);
        root.right = buildTree(nums,mid+1,end);

        return root;
    }
}
