/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode,TreeNode> map = new HashMap<>(); // children, parent pair
        fill(map, root);
        // bfs from target node in three directions
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int level = 0;
        while(!q.isEmpty()){
            if(level==k){
                List<Integer> ans = new ArrayList<>();
                for(TreeNode n:q){
                    ans.add(n.val);
                }
                return ans;
            }
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
        return new ArrayList<>();
    }
    static void fill(Map<TreeNode,TreeNode> map, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
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
        }
    }
}