/*
you are given K sorted linkedlist,

you need to merge all of them and return the head of the new linkedlist

approach 1:
store all the data in an ArrayList and sort the arraylist, then create a new linkedlist with the array elements

approach 2: 
merge all the linkedlist without sorting
then do a mergesort on the list

approach 3:
make a function that merges two sorted lists,
now merge all the lists one by one

approach 4:
use minheap to find the minimum node, then add it to the dummy node list
also maintain pointers so you could traverse the list
as the pointer move forwards make sure to add the next node to the minheap

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0) return null;
        ListNode merge = new ListNode(-1);
        PriorityQueue<Pair<ListNode,Integer>> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a.first().val,b.first().val)
        );
        ListNode dummy = merge;
        ListNode pointers[] = new ListNode[k];
        for(int i=0; i<k; i++){
            pointers[i] = lists[i];
            if(pointers[i]!=null) pq.add( new Pair(pointers[i],i) );
        }
        // System.out.println(pq.size());
        while(!pq.isEmpty()){
            Pair<ListNode,Integer> pair = pq.poll();
            ListNode node = pair.first();
            int i = pair.second();
            if(pointers[i]!=null) pointers[i] = pointers[i].next;
            dummy.next = node;
            dummy = node;
            if(pointers[i]!=null) pq.add(new Pair(pointers[i],i));
        }
        return merge.next;
    }
    static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K first() {
            return key;
        }
        public V second() {
            return value;
        }
    }
}