package _5_Binary_Tree.BT_Problems;

/*
    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

import java.util.*;

class TNode{
    int val;
    TNode left=null,right=null, next = null;
    TNode(int val, TNode left, TNode right, TNode next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class _23_Populate_Next_Right_pointers_of_Tree {
    public TNode connect(TNode root) {
        if(root == null)
            return null;

        Queue<TNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            if(q.size()==1){  //if only one ele(i.e, for root), just add it's children to queue
                TNode node = q.remove();
                if(node.left!=null)
                    q.add(node.left);

                if(node.right!=null)
                    q.add(node.right);
            }else{
                int n = q.size();
                TNode prev = null;
                for(int i=0;i<n;i++){  //connecting all nodes in arow
                    TNode node = q.remove();
                    if(node.left!=null)
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);

                    if(prev != null)
                        prev.next = node;

                    prev = node;
                }
            }
        }

        return root;
    }
}
