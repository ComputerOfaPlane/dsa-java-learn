/*
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].

brute and better approaches will be just to iterate over all the pairs and count them

optimal approach 1: mergesort divide and conquer strategy

in merge sort we constantly divide the array and then keep merging the sorted array

in this we cannot exactly use count inversion logic
6 7 8     3 3 3
if we do 6>2*3? no, then the pointer will move forward but there exists more elements which will form pairs

what we can do is
6 7 8     3 3 3
iterate from left to mid
for every i element move the pointer of second array as right as possible
then do count += rightpointer - index of first right array element
increment pointer of first array

*/
import java.util.*;
class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
    static int mergesort(int arr[], int left, int right){
        int count = 0;
        if(left>=right) return count;
        int mid = (right+left)/2;
        count += mergesort(arr,left,mid)+mergesort(arr,mid+1,right)+merge(arr,left,mid,right);
        return count;
    }
    static int merge(int arr[], int left, int mid, int right){
        int count = 0;
        int i1 = left, i2 = mid+1;
        int temp[] = new int[right-left+1];
        int j = 0;
        while(i1<=mid){
            while(i2<=right && ((long)arr[i1]>(long)2L*arr[i2])) i2++;
            count+=(i2-mid-1);
            i1++;
        }
        i1=left;
        i2=mid+1;
        while(i1<=mid && i2<=right){
            if(arr[i1]>arr[i2]) temp[j++] = arr[i2++];
            else temp[j++] = arr[i1++];
        }
        while(i1<=mid) temp[j++] = arr[i1++];
        while(i2<=right) temp[j++] = arr[i2++];
        for(int i=left; i<=right; i++) arr[i]=temp[i-left];
        return count;
    }
}
/*
mistakenly also managed to get accepted with a O(n^2) solution

in the merge function what i was doing was, first figuring out if there definitely exists an element that can form a pair,
    if yes, then ran a loop from left to mid with right pointer constant, if found mid-i+1 is added to count with break;
    and right array pointer increments

class Solution {
    public int countRevPairs(int N, int arr[]) {
        return mergesort(arr,0,N-1);
    }
    static int mergesort(int arr[], int left, int right){
        int count = 0;
        if(left>=right) return count;
        int mid = (right+left)/2;
        count += mergesort(arr,left,mid)+mergesort(arr,mid+1,right)+merge(arr,left,mid,right);
        return count;
    }
    static int merge(int arr[], int left, int mid, int right){
        int count = 0;
        int i1 = left, i2 = mid+1;
        int temp[] = new int[right-left+1];
        int j = 0;
        while(i1<=mid && i2<=right){
            if((long)arr[mid]>(long)2L*arr[i2]) for(int i=left; i<=mid; i++){
                long n1 = arr[i];
                long n2 = 2L*arr[i2];
                if(n1>n2){
                    count += (mid-i+1);
                    break;
                }
            }
            i2++;
        }
        i1=left;
        i2=mid+1;
        while(i1<=mid && i2<=right){
            if(arr[i1]>arr[i2]) temp[j++] = arr[i2++];
            else temp[j++] = arr[i1++];
        }
        while(i1<=mid) temp[j++] = arr[i1++];
        while(i2<=right) temp[j++] = arr[i2++];
        for(int i=left; i<=right; i++) arr[i]=temp[i-left];
        return count;
    }
}

*/