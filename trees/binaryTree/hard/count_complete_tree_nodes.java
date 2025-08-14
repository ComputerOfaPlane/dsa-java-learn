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
 // approach 1 a simple traversal
 // apporach 2: use the property of a complete tree, no. of nodes 2^height
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = lheight(root);
        int right = rheight(root);
        if(left==right) return (1<<left) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    static int lheight(TreeNode node){
        if(node==null) return 0;
        return 1 + lheight(node.left);
    }
    static int rheight(TreeNode node){
        if(node==null) return 0;
        return 1 + rheight(node.right);
    }
}