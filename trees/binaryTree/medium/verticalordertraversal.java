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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b)->{
            int ret = Integer.compare(a.x,b.x);
            if(ret!=0) return ret;
            int ret2 = Integer.compare(a.y,b.y);
            if(ret2!=0) return ret2;
            int ret3 = Integer.compare(a.node.val,b.node.val);
            return ret3;
        });
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(0,0,root));
        while(!q.isEmpty()){
            Data data = q.poll();
            pq.add(data);
            if(data.node.left!=null) q.add(new Data(data.x-1,data.y+1,data.node.left));
            if(data.node.right!=null) q.add(new Data(data.x+1,data.y+1,data.node.right));
        }
        int prev = pq.peek().x;
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            if(prev!=pq.peek().x){
                prev = pq.peek().x;
                ans.add(new ArrayList<>(list));
                list = new ArrayList<>();
                list.add(pq.peek().node.val);
            }
            else list.add(pq.peek().node.val);
            pq.poll();
        }
        if(!list.isEmpty()) ans.add(new ArrayList<>(list));
        return ans;
    }
    static class Data{
        int x,y;
        TreeNode node;
        Data(int a, int b, TreeNode n){
            this.x = a;
            this.y = b;
            this.node = n;
        }
    }
}