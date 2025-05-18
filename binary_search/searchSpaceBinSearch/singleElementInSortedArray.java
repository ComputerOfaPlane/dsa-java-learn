/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

approach:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

observations:

in pairs, left element always occurs at even index
right element always occurs at odd index

if this does not happen then we can definitely say there had been an single element towards the left so remove the right search space

else this hold true, remove the left search space

*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]) left = mid + 2;
                else right = mid-1; 
            }
            else{
                if(nums[mid]==nums[mid-1]) left = mid+1;
                else right = mid;
            }
        }
        return nums[left];
    }
}