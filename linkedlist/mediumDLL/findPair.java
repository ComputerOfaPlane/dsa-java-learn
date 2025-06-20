/*
given a linkedlist, find all pair of elements that add up to give sum as target

approach 1: enumerate over all pairs

approach 2: use hashing, store the previously visited elements
            needed = target - curr, check for this needed in the hashset

approach 3: 2 pointers

left = head,
right = tail of the list

if sum == target 
    add it to data structure
    move left to next
    move right to prev

if sum>x we need to decrease sum so move right to prev
else move left to next

*/
/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        /*Node temp = head;
        Set<Integer> set = new HashSet<>();
        while(temp!=null){
            int data = temp.data;
            int needed = target - data;
            if(set.contains(needed)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(needed);
                list.add(data);
                ans.add(list);
            }
            set.add(data);
            temp = temp.next;
        }
        Collections.sort(ans,(a,b)->{
            int ret = Integer.compare(a.get(0),b.get(0));
            return ret==0?Integer.compare(a.get(1),b.get(1)):ret;
        });*/
        Node left = head, right = head;
        while(right.next!=null) right = right.next;
        while(left.data<right.data){
            int sum = left.data + right.data;
            if(sum==target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left.data);
                list.add(right.data);
                ans.add(list);
                left = left.next;
                right = right.prev;
            }
            else if(sum>target) right = right.prev;
            else left = left.next;
        }
        return ans;
    }
}
