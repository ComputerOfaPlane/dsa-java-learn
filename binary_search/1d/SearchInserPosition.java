/*
find an index in the sorted array such that after we insert the target element, the resultant array is till sorted

eg:
0 1 2 3 4 5 6 7 8 9
1 2 3 5 5 5 6 6 7 8 
                      
insert 4 = 3

*/
import java.util.*;
class Search {
    static int searchInsertPosition(int arr[], int left, int right, int target){
        // just lower bound of target
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]>=target) right=mid-1;
            else left = mid+1;
        }
        return left;
    }
}