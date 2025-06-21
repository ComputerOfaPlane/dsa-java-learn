/*
flatten a linkedlist, so basically merge k sorted linkedlists
*/
class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root.next==null) return root;
        Node nextnode = flatten(root.next);
        Node merged = merge(root,nextnode);
        return merged;
    }
    static Node merge(Node a, Node b){
        Node dummy = new Node(-1);
        Node dt = dummy;
        while(a!=null && b!=null){
            if(a.data <= b.data){
                dt.bottom = a;
                dt = dt.bottom;
                a = a.bottom;
            }
            else{
                dt.bottom = b;
                dt = dt.bottom;
                b = b.bottom;
            }
        }
        while(a!=null){
            dt.bottom = a;
            dt = dt.bottom;
            a = a.bottom;
        }
        while(b!=null){
            dt.bottom = b;
            dt = dt.bottom;
            b = b.bottom;
        }
        return dummy.bottom;
    }
}