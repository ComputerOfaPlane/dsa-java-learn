// use iterative approach with stack
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
// use iterative approach with stack
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
class BSTIterator_intended {
    
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
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
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index = -1;
    public BSTIterator(TreeNode root) {
        fill(root,list);
        index = 0;
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index<list.size();
    }
    static void fill(TreeNode root, List<Integer> list){
        if(root==null) return;
        fill(root.left,list);
        list.add(root.val);
        fill(root.right,list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */