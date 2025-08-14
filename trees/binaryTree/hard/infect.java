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
    public int amountOfTime(TreeNode root, int start) {
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode,TreeNode> map = new HashMap<>(); // children, parent pair
        TreeNode target = fill(map, root,start);
        // bfs from target node in three directions
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int level = -1;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode node = q.poll();
                visited.add(node);
                TreeNode parent = map.get(node);
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(parent!=null && !visited.contains(parent)) q.add(parent);
                if(left!=null && !visited.contains(left)) q.add(left);
                if(right!=null && !visited.contains(right)) q.add(right);
            }
            level+=1;
        }
        return level;
    }
    static TreeNode fill(Map<TreeNode,TreeNode> map, TreeNode root, int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode ans = null;
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if(parent.left!=null){
                map.put(parent.left,parent);
                q.add(parent.left);
            }
            if(parent.right!=null){
                map.put(parent.right,parent);
                q.add(parent.right);
            }
            if(parent.val==start) ans = parent;
        }
        return ans;
    }
}