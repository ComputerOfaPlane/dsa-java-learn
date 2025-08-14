/**
Approaches:
1. Since it is a preorder: traverl to the preorder the array, then insert each node one by one from the root O(n^2)
2. Find the inorder using the property: then use divide and conquer technique to build the tree O(nlogn + n)
3. optimal: use the concept of ranges and build the tree like we did to check if the binary tree is valid or not
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(Integer.MAX_VALUE,new int[]{0},preorder);
    }
    static TreeNode build(int max, int index[], int preorder[]){
        if(index[0]==preorder.length || preorder[index[0]]>max) return null;
        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]+=1;
        root.left = build(root.val,index,preorder);
        root.right = build(max, index, preorder);
        return root;
        
    }
}