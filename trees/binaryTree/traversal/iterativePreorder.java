class Solution {
    // normal dfs
    static ArrayList<Integer> preorder(Node root) {
        // write code here
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        ArrayList<Integer> ans = new ArrayList<>();
        if(temp==null) return null;
        stack.push(temp);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            ans.add(node.data);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return ans;
    }
}