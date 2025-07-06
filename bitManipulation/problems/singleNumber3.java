/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

brute force: hashing

best:
find the rightmost set bit number of the xor of the entire array

use this number to partition the array into two buckets
while adding to buckets, do xor
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums) xor^=i;
        xor = (xor&(xor-1))^xor; // find the rightmost set bit number
        int bucket1 = 0, bucket2 = 0;
        for(int i:nums){
            if((xor&i)==xor) bucket1^=i;
            else bucket2^=i;
        }
        return new int[]{bucket1,bucket2};
    }
}