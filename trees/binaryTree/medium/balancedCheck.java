/*
Check if a tree is height balanced or not, difference between height of left subtree and right subtree must be less than equal to 1

*/
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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        /* Find the height at each node and compare
        int left = length(root.left);
        int right = length(root.right);
        if(Math.abs(left-right)>1) return false;
        return isBalanced(root.left)&&isBalanced(root.right);
        */
        int length = length(root);
        // System.out.println(length);
        return length>0;
    }
    static int length(TreeNode root){ // function that either returns the height of the tree or confirms it is not balanced
        if(root==null) return 0;
        int left = length(root.left);
        int right = length(root.right);
        if(Math.abs(left-right)>1) return -1;
        return (left==-1||right==-1)?-1:1+Math.max(left,right);
    }
}