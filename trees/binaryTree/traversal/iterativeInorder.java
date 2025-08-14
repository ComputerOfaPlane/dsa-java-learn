/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()) break;
                root = stack.pop();
                ans.add(root.data);
                root = root.right;
            }
            
        }
        return ans;
    }
}