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
2 ways to solve this recursively and iteratively

iteratively using level order traversal

recursively using the following recurrence

t(n) = 1+max(t(n.left),t(n.right));
*/
class Solution {
    public int maxDepth(TreeNode root) {
        /*

        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

        */
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            size+=1;
        }
        return size;
    }
}