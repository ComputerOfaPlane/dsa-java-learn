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
problem requires to solve 2 separate problems:
1. search the node
2. delete it

there can be a number of possible solutions

I have tried to make the left children as the new parent, and right subtree is added to the rightmost leaf of the left subtree
I have tried to solve like: find the node, then treat this node as the root of a tree and delete it
edge cases:
- first return null if root is null
- if root is key then directly delete it
*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key) return deleteroot(root);
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val<key){
                if(temp.right!=null && temp.right.val==key){
                    temp.right = deleteroot(temp.right);
                    break;
                }else temp = temp.right;
            }else{
                if(temp.left!=null && temp.left.val==key){
                    temp.left = deleteroot(temp.left);
                    break;
                }else temp = temp.left;
            }
        }
        return root;
    }
    static TreeNode deleteroot(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left==null && right==null) return null; // key node is the leaf element
        if(left==null) return right; // left subtree is null
        root.left = null;
        root.right = null;
        TreeNode temp = left;
        while(temp.right!=null) temp = temp.right;
        temp.right = right;
        return left;
    }
}