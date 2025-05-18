/*
search in a rotated sorted array:
given a sorted array which may be rotated n times, where 0<=n
you need to search a target element in the array in logn time complexity

using binary search idea:

suppose we have an array

5 6 7 8 1 2 3 4

we need to search 7

first we set our left and right pointers

calculate mid, if found then return

else there are two search spaces - left search space and right search space

for each of these search space one must be true; that is one of the search space must definitely be sorted

if that search space is sorted, check for whether target element exists within that search space?
    if yes-> elminate the other search space
    else eliminate the current search space

this solution will work when there are no duplicates in the array but may may if there are for edge cases like

nums = [2,2,2,2,2,2,2,2,2,2,2,1,2,2,2]

in that case we need to add a precondition that does left++, right-- until left,mid and right elements are different

this gives us a average time complexity of logn but worst time complexity is still O(n)
*/

class Solution {
    public int search(int[] nums, int target) {
        int breakpoint = -1, n = nums.length;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){ // left part is sorted
                if(nums[left]<=target && target<=nums[mid]) right = mid - 1;
                else left = mid+1;
            }
            else{ // right part is sorted
                if(nums[mid]<=target && target<=nums[right]) left = mid + 1;
                else right = mid -1 ;
            }
        }
        return -1;
    }
    public boolean search(int[] nums, int target) {
        int breakpoint = -1, n = nums.length;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[left] && nums[mid]==nums[right]){
                left++;right--;
                continue;
            }
            if(nums[left]<=nums[mid]){ // left part is sorted
                if(nums[left]<=target && target<=nums[mid]) right = mid - 1;
                else left = mid+1;
            }
            else{ // right part is sorted
                if(nums[mid]<=target && target<=nums[right]) left = mid + 1;
                else right = mid -1 ;
            }
        }
        return false;
    }
}