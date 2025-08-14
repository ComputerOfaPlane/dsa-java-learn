// make the tree hold true for children sum property
import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        int left = root.left==null?Integer.MAX_VALUE:root.left.data;
        int right = root.right==null?Integer.MAX_VALUE:root.right.data;
        if(root.data>left && root.left!=null) root.left.data = root.data;
        if(root.data>right && root.right!=null) root.right.data = root.data;
        changeTree(root.left);
        changeTree(root.right);
        root.data = (root.left==null?0:root.left.data) + (root.right==null?0:root.right.data);

    }
}
/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
// check
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if(root==null || leaf(root)) return 1;
        int l = (root.left!=null)?root.left.data:0;
        int r = (root.right!=null)?root.right.data:0;
        if(l+r!=root.data) return 0;
        if(isSumProperty(root.left)==0) return 0;
        if(isSumProperty(root.right)==0) return 0;
        return 1;
    }
    static boolean leaf(Node node){
        return node.left==null && node.right==null;
    }
}