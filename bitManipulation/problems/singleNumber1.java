/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

use xor
*/
class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xor^=nums[i];
        }
        return xor;
    }
}