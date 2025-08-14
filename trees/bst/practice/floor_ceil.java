/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    public static int floor(Node root, int key) {
        // Code here
        int floor = Integer.MIN_VALUE;
        while(root!=null){
            if(root.data==key) return key;
            else if(root.data<key){
                floor = Math.max(floor,root.data);
                root = root.right;
            }
            else{
                root = root.left;
            } 
        }
        return floor==Integer.MIN_VALUE?-1:floor;
    }
}
class Tree {
    int findCeil(Node root, int key) {
        int ceil = Integer.MAX_VALUE;
        while(root!=null){
            if(root.data==key) return key;
            else if(root.data<key){
                root = root.right;
            }
            else{
                ceil = Math.min(ceil,root.data);
                root = root.left;
            } 
        }
        return ceil==Integer.MAX_VALUE?-1:ceil;
    }
}
