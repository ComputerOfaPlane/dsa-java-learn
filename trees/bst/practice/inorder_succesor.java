/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;
public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        int successor = -1, predecessor = -1;
        while(temp!=null){
            if(key>=temp.data) temp = temp.right;
            else{
                successor = temp.data;
                temp = temp.left;
            }
        }
        while(root!=null){
            if(key<=root.data) root = root.left;
            else{
                predecessor = root.data;
                root = root.right;
            }
        }
        list.add(predecessor);
        list.add(successor);
        return list;
    }
}





/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {

    // kindof like binary search
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        
        Node temp = root;
        int ans = -1;
        while(temp!=null){
            if(x.data>=temp.data) temp = temp.right;
            else{
                ans = temp.data;
                temp = temp.left;
            }
        }
        return ans;
    }

    // the is approach is kindof like doing an inorder, using the inorder property, return the first node that is greater than key
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor_brute(Node root, Node x) {
        // add code here.
        if(root==null) return -1;
        int left = inorderSuccessor(root.left,x);
        if(left!=-1) return left;
        if(root.data>x.data) return root.data;
        int right = inorderSuccessor(root.right,x);
        if(right!=-1) return right;
        return -1;
    }
}
