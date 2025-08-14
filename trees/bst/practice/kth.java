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
    public int kthSmallest(TreeNode root, int k) {
        int number[] = {k};
        find(root,number);
        return number[0];
    }
    static boolean find(TreeNode root, int number[]){
        if(root==null) return false;
        if(find(root.left,number)) return true;
        number[0]-=1;
        if(number[0]==0){
            number[0] = root.val;
            return true;
        }
        if(find(root.right,number)) return true;
        return false;
    }
}