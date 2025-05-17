/*
find the upper bound of target in a sorted array

what is upper bound?
upper bound is the smallest index in a sorted array where the value at that index is strictly greater than the target value

eg:
0 1 2 3 4 5 6 7 8 9
1 2 3 5 5 5 6 6 7 8 
                          
upper bound of 5 = 6
upper bound of 4 = 3

*/
import java.util.*;
class UpperBound {
    static int upperbound(int arr[], int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}