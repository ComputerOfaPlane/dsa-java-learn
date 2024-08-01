/*
we have an array consisting of just three numbers and we need to sort them

Brute Force:
use merge sort, quick sort or any traditional sorting algorithm
Time = O(nlogn) or O(n^2)
space = O(1)

Better:
2 pass solution
iterate through the array
first time to count the frequency of each element
second time to put it in the array
time = O(n) + O(n)
space = O(1)

Best: Dutch National flag algorithm
3 pointers approach
consider and imaginary array
000000 1111111 ........ 222222222
       |       |        |
      low     mid     high
mid to high-1 is unsorted
traverse through mid to high
if 0 is encountered swap with low and increment low and mid
if 1 is found just move forward (mid++)
else if 2 then just swap with high
time = O(n)
space = O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        
        int n=nums.length;

        int low=0,mid=0,high=n-1;

        while(mid<=high){
            int elm=nums[mid];
            if(elm==0){
                swap(nums,mid,low);
                low++;mid++;
            }
            else if(elm==2){
                swap(nums,mid,high);
                high--;
            }
            else{
                mid++;
            }
        }
    }
    static void swap(int arr[], int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}