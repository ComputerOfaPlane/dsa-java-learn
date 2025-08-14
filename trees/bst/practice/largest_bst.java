// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
/*
brute force is obvious: O(n^2) for each node, check whether it is the root of the bst
optimal: this one
*/
class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        return find(root).size;
    }
    static ans find(Node root){
        if(root==null) return new ans(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        ans l = find(root.left);
        ans r = find(root.right);
        
        if(l.max<root.data && root.data<r.min){
            return new ans(Math.min(root.data,l.min),Math.max(root.data,r.max),l.size+r.size+1);
        }
        
        return new ans(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(l.size,r.size));
    }
    static class ans{
        int max, min, size;
        ans(int small, int big, int size){ // min , max, size
            this.min = small;
            this.max = big;
            this.size = size;
        }
    }
}