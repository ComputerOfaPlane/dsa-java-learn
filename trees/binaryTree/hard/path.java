/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        travel(root,ans,new ArrayList<>());
        return ans;
    }
    static void travel(Node root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> l){
        if(root==null) return;
        l.add(root.data);
        if(leaf(root)){
            ans.add(new ArrayList<>(l));
            l.remove(l.size()-1);
            return;
        }
        travel(root.left,ans,l);
        travel(root.right,ans,l);
        l.remove(l.size()-1);
    }
    static boolean leaf(Node node){
        return node.left==null && node.right==null;
    }
}