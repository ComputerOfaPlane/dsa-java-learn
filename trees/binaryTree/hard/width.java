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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1L,root));
        long ans = 1L;
        while(!q.isEmpty()){
            int s = q.size();
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for(int i=0; i<s; i++){
                Pair pair = q.poll();
                // System.out.println(pair);
                min = Math.min(min,pair.pos);
                max = Math.max(max,pair.pos);
                if(pair.node.left!=null) q.add(new Pair(2L*pair.pos,pair.node.left));
                if(pair.node.right!=null) q.add(new Pair(2L*pair.pos+1,pair.node.right));
            }
            // System.out.println();
            ans = Math.max(1L+max-min,ans);
        }
        return ans>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)ans;
    }
    static class Pair{
        long pos;
        TreeNode node;
        Pair(long a, TreeNode node){
            this.pos = a;
            this.node = node;
        }
        @Override
        public String toString(){
            return "{"+this.pos+","+this.node.val+"}";
        }
    }
}