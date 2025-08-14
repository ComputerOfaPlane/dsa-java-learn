/**
approaches: 
1. O(N^2) iterate through all the nodes, then each node iterate again to find the needed value
2. O(NlogN): same as before but, for second part we make use of the fact this is a BST
3. O(N+N): find the inorder traversal, then do a 2 pointer on the traversal
4. use bst iterator, build the iterator call such that both inorder and rev inorder can be done together
 */
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
    public boolean findTarget(TreeNode root, int k) {
        Inorder in = new Inorder(root);
        RevInorder rev = new RevInorder(root);
        while(in.hasNext() && rev.hasNext()){
            int a = in.peek();
            int b = rev.peek();
            if(a==b) break;
            int sum = a+b;
            if(sum==k) return true;
            if(sum>k) rev.next();
            else in.next();
        }
        return false;
    }
    static class Inorder {
    
        Stack<TreeNode> stack = new Stack<>();

        public Inorder(TreeNode root) {
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
        }
        public int peek(){
            return stack.peek().val;
        }
        public int next() {
            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
                while(stack.peek().left!=null){
                    stack.push(stack.peek().left);
                }
            }
            return node.val;
        }
        
        public boolean hasNext() {
            return stack.size()>0;
        }
    }
    static class RevInorder {
    
        Stack<TreeNode> stack = new Stack<>();

        public RevInorder(TreeNode root) {
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
        }
        public int peek(){
            return stack.peek().val;
        }
        public int next() {
            TreeNode node = stack.pop();
            if(node.left!=null){
                stack.push(node.left);
                while(stack.peek().right!=null){
                    stack.push(stack.peek().right);
                }
            }
            return node.val;
        }
        
        public boolean hasNext() {
            return stack.size()>0;
        }
    }
}