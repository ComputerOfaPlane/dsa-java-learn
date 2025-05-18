/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

firstly lets imagine, there exists only 1 peak element in the array

if we try to plot the elements

|                          
|         mid                 
|         /\                 
|        /  \                
|       /    \               
|      /      \              
|     /       high              
|    low                     
|__________________________

keep low and high,
calculate mid
if a[mid-1] < a[mid] > a[mid+1] is true we found a peak elements ladies and gentlemen

else

there are two possible cases

1. the mid is towards left of actual peak     - this case can be found out by arr[mid-1]<arr[mid], remove the left search space
2. the mid is towrads right of actual peak    - this case can be found out by arr[mid]>arr[mid+1], remove the right search space

now if there are multiple peaks, it may look like,

|                   /\       
|                  /  \    /\                      
|         /\      /    \  /  \                       
|        /  \    /      \/                          
|       /    \  /                                 
|      /      \/                                  
|     /                     
|                         
|__________________________

we can do the same concept:
calculate mid, check mid for peak condition
else
reduce search space accordingly, as it will eventually reduce to a 1 peak problem

*/
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int left = 1, right = n-2;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-2]<nums[n-1]) return n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            if(nums[mid-1]<nums[mid]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}