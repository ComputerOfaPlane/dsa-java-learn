/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

approach:

sliding window,

we can consider this problem as the largest subarray with atmost k zeros

better: O(2N)

we can make it O(N)

by, lets say if zeros becomes more than k, we will do left+=1 and right+=1
this would not increase the size of the window
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, n = nums.length, curr = 0;
        while(right<n){
            if(nums[right]==0) curr+=1;
            /*while(curr>k){
                if(nums[left]==0) curr-=1;
                left+=1;
            }*/
            if(curr>k){
                if(nums[left]==0) curr-=1;
                left+=1;
            } 
            else max = Math.max(right-left+1,max);
            right+=1;
        }
        return max;
    }
}