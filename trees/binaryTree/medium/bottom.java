/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/
// same as top view, but we change the map everytime
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        int min = 0, max = 0;
        Map<Integer,Node> map =new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            map.put(pair.x,pair.node); // changes the value of key everytime
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