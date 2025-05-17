/*
find the lower bound of a target in a sorted array

what is lower bound?
lower bound is the smallest index in the sorted array at which the lower bound element is greater than or equal to target

eg:
0 1 2 3 4 5 6 7 8 9
1 2 3 5 5 5 6 6 7 8 
                          
lower bound of 5 = 3
lower bound of 4 = 3

*/
import java.util.*;
class LowerBound {
    static int lowerbound(int arr[], int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>=target) right = right-1;
            else left = left+1;
        }
        return left;
    }
}