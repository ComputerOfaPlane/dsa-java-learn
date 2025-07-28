class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) pq.add(i);
        int ans = 0;
        while(k-->0) ans = pq.poll();
        return ans;
    }
}
class Solution {
    public static int kthSmallest(int[] nums, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums) pq.add(i);
        int ans = 0;
        while(k-->0) ans = pq.poll();
        return ans;
    }
}