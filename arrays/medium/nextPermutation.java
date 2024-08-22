/*
Find the lexographical next permutation of the given array

brute force:
1. find each permutation, // idk how to do this
2. find yo ans
time = O(n! * n)
space=O(1)

better:
1. find the breakpoint
2. find the element bigger then the element at breakpoint
2. swap them and reverse the rest
time = O(N) + O(N) + O(N) = O(3N)
space = O(1)
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int breakpoint=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakpoint=i;
                break;
            }
        }
        if(breakpoint==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>breakpoint;i--){
            if(nums[i]>nums[breakpoint]){
                swap(nums,i,breakpoint);
                break;
            }
        }
        reverse(nums,breakpoint+1,n-1);
    }
    static void swap(int arr[], int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    static void reverse(int a[], int i, int j){
        while(i<j){
            swap(a,i,j);
            i++;j--;
        }
    }
}