// we can do the same using just one stack
/*
go as left as possible until null
then move right if possible and continue, else add
*/
/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        // Your code goes here
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node.data);
            if(node.left!=null) stack1.push(node.left);
            if(node.right!=null) stack1.push(node.right);
        }
        while(!stack2.isEmpty()) list.add(stack2.pop());
        return list;
    }
}
