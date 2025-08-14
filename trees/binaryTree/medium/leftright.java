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
// same as top and bottom view, instead of mapping x coordinates, we map y coordinates
// for left we do not replace, for right we replace

// recursive
// root -> right -> left, the idea remains same about the replacement of values of keys
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,TreeNode> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        travel(root,0,map);
        int s = map.size();
        for(int i=0; i<s; i++) ans.add(map.get(i).val);
        return ans;
    }
    static void travel(TreeNode node, int level, Map<Integer,TreeNode> map){
        if(node==null) return;
        if(!map.containsKey(level)) map.put(level,node);
        travel(node.right,level+1,map);
        travel(node.left,level+1,map);
    }
}


// iterative
class Solutioni {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        int max = 0;
        Map<Integer,TreeNode> map =new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            map.put(pair.y,pair.node);
            max = Math.max(max,pair.y);
            if(pair.node.left!=null) q.add(new Pair(pair.y+1,pair.node.left));
            if(pair.node.right!=null) q.add(new Pair(pair.y+1,pair.node.right));
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<=max; i++){
            ans.add(map.get(i).val);
        }
        return ans;
    }
    static class Pair{
        int y;
        TreeNode node;
        Pair(int a, TreeNode n){
            this.y = a;
            this.node = n;
        }
    }
}