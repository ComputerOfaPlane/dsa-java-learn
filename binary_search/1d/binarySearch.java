/*
binary search:
the array must be sorted
we keep to pointers, which define the search space
find the mid element
if mid element is equal to the target element found
else if mid element is less than the target so decrease the search space make left mid +1
else right is mid-1
*/

class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
class Solution {
    public int search(int[] nums, int target) {
       return binarySearch(nums,0,nums.length-1,target);
    }
    static int binarySearch(int nums[], int l, int r, int target){
        int mid = (l+r)/2;
        if(l>r) return -1;
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return binarySearch(nums,mid+1,r,target);
        else return binarySearch(nums, l, mid-1, target);
    }
}

/*
overflow case during calculation of mid:

mid = (low+high)
        _______
           2

either take long or do math derivation

low+high = low+high-low+low
         = 2 low + (high-low)

         (2 low + (high-low))/2
         == 2low/2 + (high-low)/2
         =

low + (high-low)/2



*/