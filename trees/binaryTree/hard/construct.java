// unique binary trees can only be made with inorder & preorder or inorder & postorder
// use divide and conquer strategy to construct the trees
/*
steps:
find the root
find the range of left from inorder, pass this as a subproblem
find the range of right from inorder, pass this as a subproblem
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
class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> in = new HashMap<>();
        int n = preorder.length;
        for(int i=0; i<n; i++){
            in.put(inorder[i],i);
        }
        int idx[] = {0};
        TreeNode root = build(preorder,inorder,0,n-1,idx,n,in);
        return root;
    }
    static TreeNode build(int preorder[], int inorder[], int left, int right, int idx[], int n, Map<Integer,Integer> in){
        if(left>right) return null;
        TreeNode root = null;
        if(idx[0]<n){
            root = new TreeNode(preorder[idx[0]]);
            int i = in.get(root.val);
            idx[0]+=1;
            root.left = build(preorder,inorder,left,i-1,idx,n,in);
            // idx[0]+=1;
            root.right = build(preorder,inorder,i+1,right,idx,n,in);
        }
        return root;
    }
}
class Solution2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> in = new HashMap<>();
        int n = postorder.length;
        for(int i=0; i<n; i++){
            in.put(inorder[i],i);
        }
        int idx[] = {n-1};
        TreeNode root = build(postorder,inorder,0,n-1,idx,in);
        return root;
    }
    static TreeNode build(int postorder[], int inorder[], int left, int right, int idx[], Map<Integer,Integer> in){
        if(left>right) return null;
        TreeNode root = null;
        if(idx[0]>=0){
            root = new TreeNode(postorder[idx[0]]);
            int i = in.get(root.val);
            idx[0]-=1;
            root.right = build(postorder,inorder,i+1,right,idx,in);
            root.left = build(postorder,inorder,left,i-1,idx,in);
            // idx[0]+=1;
        }
        return root;
    }
}