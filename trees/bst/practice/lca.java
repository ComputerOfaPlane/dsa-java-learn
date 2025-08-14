/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
use the bst property, find both the nodes as well as track their common ancestors
the last node that was common in the path to the nodes is the lca
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp1 = root, temp2 = root, lca = root;
        boolean found1 = false, found2 = false;
        while(temp1!=null || temp2!=null){
            if(!found1 && temp1!=null){
                if(temp1.val==p.val) found1 = true;
                else if(temp1.val>p.val) temp1 = temp1.left;
                else temp1 = temp1.right;
            }
            if(!found2 && temp2!=null){
                if(temp2.val==q.val) found2 = true;
                else if(temp2.val>q.val) temp2 = temp2.left;
                else temp2 = temp2.right;
            }
            if(temp1.val==temp2.val) lca = temp1;
            else break;
        }
        return lca;
        /*// for a binary tree
        if(root==null || root.val==p.val || root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        return (left==null)?right:left;*/
    }
}