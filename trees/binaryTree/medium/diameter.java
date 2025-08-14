/*
a diameter of the tree can be said as the:
1. longest path between two nodes
2. the path may or may not include the root node

approach: the maximum of the sum of height of left subtree and the right subtree
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
// optimal O(n)
// using max[0] as a reference variable
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int max[] = new int[1];
        find(root,max);
        return max[0];
    }
    static int find(TreeNode root, int max[]){
        if(root==null) return 0;
        int left = find(root.left,max);
        int right = find(root.right,max);
        max[0] = Math.max(max[0],left+right);
        return 1+Math.max(left,right);
    }
}

/*
Brute force: O(N^2)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        travel(root,list);
        int max = -1;
        for(int i:list) max = Math.max(max,i);
        return max;
    }
    static void travel(TreeNode node, List<Integer> ans){
        if(node==null) return;
        ans.add(dia(node));
        travel(node.left,ans);
        travel(node.right,ans);
    }
    static int len(TreeNode root){
        if(root==null) return 0;
        int left = len(root.left);
        int right = len(root.right);
        return 1+Math.max(left,right);
    }
    static int dia(TreeNode root){
        if(root==null) return 0;
        int left = len(root.left);
        int right = len(root.right);
        return left + right;
    }
}
*/