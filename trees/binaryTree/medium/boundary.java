/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        Node a = node.left, b=node, c=node.right;
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(node.data);
        
        // left bounday
        while(a!=null){
            if(!leaf(a)) ans.add(a.data);
            if(a.left!=null) a= a.left;
            else a = a.right;
        }
        
        // postorder traversal
        if(!leaf(b)) add(b,ans);
        
        // rightboundary
        ArrayList<Integer> temp = new ArrayList<>();
        while(c!=null){
            if(!leaf(c)) temp.add(c.data);
            if(c.right!=null) c= c.right;
            else c = c.left;
        }
        Collections.reverse(temp);
        ans.addAll(temp);
        return ans;
    }
    static boolean leaf(Node node){
        return node.left==null && node.right==null;
    }
    static void add(Node node, ArrayList<Integer> ans){
        if(node==null) return;
        add(node.left,ans);
        add(node.right,ans);
        if(leaf(node)) ans.add(node.data);
    }
}