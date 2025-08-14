/*
many possible approaches:
1. use the inorder property
    a. using the inorder property find inorder and make sure it is increasing
    b. optimise the inorder traversal using morris traversal
2. carry a range through each node and make sure that node is within the allowed range
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
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    static boolean check(TreeNode root, long min, long max){
        if(root==null) return true;
        long val = root.val;
        return val<max && val>min && check(root.left,min,Math.min(max,val)) && check(root.right,Math.max(min,val),max);
    }
}

class Solution1 {
    public boolean isValidBST(TreeNode root) {
        List<Long> in = new ArrayList<>();
        in.add(Long.MIN_VALUE);
        // System.out.println(in);
        return check(root,in)==1; // could have done morris traversal
    }
    static int check(TreeNode root, List<Long> in){
        if(root==null) return -1;
        if(check(root.left,in)==0) return 0;
        long prev = in.get(in.size()-1);
        // System.out.println("comparing = "+prev+","+root.val);
        if(prev>=(long)root.val) return 0;
        in.add((long)root.val);
        if(check(root.right,in)==0) return 0;
        return 1;
    }
}