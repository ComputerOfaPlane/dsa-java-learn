/*
count how many times a target element occurs in a sorted array

we can find first and last element using binary search like last exercise or

find lower bound
if it exists find upper boun
ans is upper bound - lower bound

else return 0

*/

public class Solution {
    public static int count(int arr[], int n, int x) {
        int idx = lowerbound(arr, 0, n-1, x);
        if(idx==n||arr[idx]!=x) return 0;
        else{
            return upperbound(arr,0,n-1,x)-idx;
        }
    }
    static int lowerbound(int arr[], int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>=target) right = right-1;
            else left = left+1;
        }
        return left;
    }
    static int upperbound(int arr[], int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}