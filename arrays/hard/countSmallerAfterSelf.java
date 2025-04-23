/*
did it on my own 

Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.


brute better you know it, i am not writing this again bruh

approach: using mergesort divide and conquer strategy

in merge sort we constantly divide the array and then keep merging the sorted arrays

in this we need to make sure that we retain the orginal poistions of the array elements

so in this, i transformed the given array into a 2d array with its index as the second element

that magic happens in updans() function, it executes before merging

if we find an element that is greater than the element in the right section then we increment the answer in that particular index

this would still give O(n^2) so I used concept of prefix sums and made another temporary array called mark, where i will just mark
and kept a running sum

this was able to solve the question in O(nlogn)
*/
import java.util.*;
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        mergesort(arr,0,n-1,ans);
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(ans[i]);
        return list;
    }
    static void mergesort(int arr[][], int left, int right, int ans[]){
        if(left>=right) return;
        int mid = (right+left)/2;
        mergesort(arr,left,mid,ans);
        mergesort(arr,mid+1,right,ans);
        updans(arr,left,mid,right,ans);
        merge(arr,left,mid,right);
    }
    static void updans(int arr[][], int left, int mid, int right, int ans[]){
        int i1=left, i2=mid+1, j=0;
        int mark[] = new int[mid-left+1];
        while(i1<=mid && i2<=right){
            if(arr[i1][0]>arr[i2][0]){
                mark[i1-left]++;
                i2++;
            }else i1++;
        }
        int curr = 0;
        for(int i=left; i<=mid; i++){
            curr+=mark[i-left];
            ans[arr[i][1]]+=curr;
        }
    }
    static void merge(int arr[][], int left, int mid, int right){
        int i1=left, i2=mid+1;
        int temp[][] = new int[right-left+1][2];
        int j = 0;
        while(i1<=mid && i2<=right){
            if(arr[i1][0]>arr[i2][0]){
                temp[j][0]=arr[i2][0];
                temp[j][1]=arr[i2][1];
                j++;i2++;
            }
            else{
                temp[j][0]=arr[i1][0];
                temp[j][1]=arr[i1][1];
                j++;i1++;
            }
        }
        while(i1<=mid){
            temp[j][0]=arr[i1][0];
            temp[j][1]=arr[i1][1];
            j++;i1++;
        }
        while(i2<=right){
            temp[j][0]=arr[i2][0];
            temp[j][1]=arr[i2][1];
            j++;i2++;
        }
        for(int i=left; i<=right; i++){
            arr[i][0] = temp[i-left][0];
            arr[i][1] = temp[i-left][1];
        }
    }
}