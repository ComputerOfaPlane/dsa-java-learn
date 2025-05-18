/*
problem: find the minimum element in the rotated sorted array

two approaches:

1. keep a minimum variable
if left is less than equal to mid,
    make answer left
    reduce left search space
else
    make answer mid
    reduce right search space

2. find the breakpoint
the idea is to find the sorted section and remove it from the search space
we have to check mid<=right, checking left<=mid will not work here

*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left]<nums[right]) return nums[0];
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[left]<=nums[right]){
                min = Math.min(min,nums[left]);
                break;
            }
            if(nums[left]<=nums[mid]){
                min = Math.min(min,nums[left]);
                left = mid+1; 
            }
            else{
                min = Math.min(min,nums[mid]);
                right = mid-1; 
            }
        }
        return min;
    }
    public int findKRotation(List<Integer> arr) {
        int left = 0, right = arr.size()-1;
        if(arr.get(left)<arr.get(right)) return 0;
        while(left<right){
            int mid = (left+right)/2;
            if(arr.get(mid)<=arr.get(right)) right = mid;
            else left = mid + 1;
        }
        return left;
        
    }
}