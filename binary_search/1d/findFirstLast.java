/*
given a sorted array, find the first index where the target element occurs and find the last element where the target element occurs

do a binary search:

0 1 2 3 4 5 6 7 8
1 2 3 3 3 4 5 6 7

find first last 3 = first is 2 and last is 4

do binary search to find first 
then again to find last

first:
if element is found reduce search space from the right

last:
if element is found reduce search space from the left


*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int n = nums.length;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                first = mid;
                right = mid-1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        left = 0;
        right = n-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]==target){
                last = mid;
                left = mid+1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return new int[]{first, last};
    }
}