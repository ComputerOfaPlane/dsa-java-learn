/*
Remove duplicates in sorted array

Brute Force:
we can create a new data str. (set or arraylist) and store unique elements in that
and copy back the array
time = O(N) traversing the array to fill data str + O(1 or N) to add elements to the data str + O(N) to fill back
space = O(N)

Better:
2 pointer approach
keep one pointer on first index
second on the next one
keep checking until unique element is found
increase pointer one by one and store the unique at first pointer location
size of array is first pointer+1
time = O(N)
space = O(1)

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int len=nums.length;
        for(int j=1;j<len;j++){
            if(nums[i]!=nums[j]){
                i+=1;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}