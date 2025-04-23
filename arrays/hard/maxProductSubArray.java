/*
Given an integer array nums, find a that has the largest product, and return the product.

brute better: iterate over all subarrays n^3 & n^2 time complexities

there are two optimal approaches O(n)
1. observation based
2. kadane algorithm

1. is more intuitive than the kadane algo
the maximum product will always be either in the prefix product or the suffix product
*/
import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0,j=n-1; i<n; i++,j--){
            prefix*=nums[i];
            suffix*=nums[j];
            max = Math.max(prefix,max);
            max = Math.max(suffix,max);
            if(prefix==0) prefix = 1;
            if(suffix==0) suffix = 1;
        }
        return max;
    }
}