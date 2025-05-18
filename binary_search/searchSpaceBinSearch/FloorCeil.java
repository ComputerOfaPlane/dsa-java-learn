/*
Floor and Ceil element: 

You're given a sorted array 'a' of 'n' integers and an integer 'x'.
Find the floor and ceiling of 'x' in 'a[0..n-1]'.

Note:

Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.

*/

import java.util.*;
class FloorCeil {
    static int[] floorceil(int arr[], int left, int right, int x){
        int ans[] = new int[2];

        // finding floor
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]<=x) left=mid+1;
            else right=mid-1;
        }
        ans[0] = right==-1?-1:arr[right];

        // finding ceil = simply lower bound
        left = 0;
        right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>=x) right = mid-1;
            else left = mid+1;
        }
        ans[1] = left==n?-1:arr[left];
        
        return ans;
    }
}