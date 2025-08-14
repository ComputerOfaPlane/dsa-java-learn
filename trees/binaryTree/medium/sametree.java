/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
do any traversal
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inorder(p,q);
    }
    static boolean inorder(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        return inorder(p.left,q.left) && p.val==q.val && inorder(p.right,q.right);
    }
}