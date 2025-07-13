/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

brute force is obvious:

optimal:

till now we have enough knowledge to find the previous greater element using monotonic stack
we can optimally traverse our window using queue

to solve this we would need both and we can use Deque 

Deque is a double ended queue data structure
we can insert and delete from both front and back

stack:
pop, poll add and removes from front
top is present at front

queue:
offer adds the element to the last
poll removes the element from the last

we can remove the element from last using pollLast

to peek: we can do peekFirst and peekLast methods

approach:
we maintain a monotonic stack of the window which stores all previous greater elements
the pge reaches the rear and can be popped when it gets out of the window
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length, ans[] = new int[n-k+1]; 
        for(int i=0; i<k; i++){
            while(!q.isEmpty() && nums[q.peek()]<nums[i]) q.pop();
            q.push(i);
        }
        ans[0] = nums[q.peekLast()];
        for(int i=k, j=1; i<n; i++, j++){
            if((i-q.peekLast())>=k) q.pollLast();
            while(!q.isEmpty() && nums[q.peek()]<nums[i]) q.pop();
            q.push(i);
            ans[j] = nums[q.peekLast()];
        }
        return ans;
    }
}