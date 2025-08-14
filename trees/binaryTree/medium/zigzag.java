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
// just level order traversal with a fliping flag to signify is right to left or not
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<s; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(!flag) Collections.reverse(list);
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}