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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return travel(root.left,root.right);
    }
    static boolean travel(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        if((a!=null && b==null)||(a==null&&b!=null)) return false;
        return a.val==b.val && travel(a.left,b.right) && travel(a.right,b.left);
    }
}