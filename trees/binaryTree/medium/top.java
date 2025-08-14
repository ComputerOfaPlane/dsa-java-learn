/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        int min = 0, max = 0;
        Map<Integer,Node> map =new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            if(!map.containsKey(pair.x)) map.put(pair.x,pair.node);
            min = Math.min(pair.x,min);
            max = Math.max(max,pair.x);
            if(pair.node.left!=null) q.add(new Pair(pair.x-1,pair.node.left));
            if(pair.node.right!=null) q.add(new Pair(pair.x+1,pair.node.right));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max; i++){
            ans.add(map.get(i).data);
        }
        return ans;
    }
    static class Pair{
        int x;Node node;
        Pair(int a, Node b){
            this.x = a;
            this.node = b;
        }
        
    }
}