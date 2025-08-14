// not confident with the optimal
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
    private static TreeNode first,middle,last,prev;
    public void recoverTree(TreeNode root) {
        first = last = middle = prev = null; // very important line else code does not work
        inorder(root);
        if(first!=null && last!=null){ // last is only not null when it holds the value that is wrong
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!=null && middle!=null){ // signifies two close nodes were wrong
        // order matters of this if else block
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && (root.val<prev.val)){
            if(first==null){
                first = prev;
                middle = root;
            }else last = root;
        }
        prev = root;
        inorder(root.right);
    }
}