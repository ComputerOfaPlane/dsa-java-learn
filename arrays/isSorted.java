/*
Check if element is sorted

approach:
traverse the array 
keep checking whether the previous element is less than or equal to the current element

time = O(n)
space = O(1)
*/
public class Solution {
    public static int isSorted(int n, int []nums) {
        int len = nums.length;
        for(int i=1;i<len; i++){
            if(nums[i]<nums[i-1]) return 0;
        }
        return 1;
    }
}