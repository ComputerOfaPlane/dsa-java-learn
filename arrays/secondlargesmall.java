/*
Finding second largest and smallest element in the array

Brute Force:
we can sort the array, then from there we can find an element by traversing appropriately
such that the required thing is not equal to largest/smallest
Time = O(NlogN)
space = O(1)

Better:
we can traverse the array twice once to find the largest or smallest
second time to find the required
time = O(N) + O(N)
Space = O(1)

Best: 2 (pointer approach)
store the largest as first element
traverse the array
find an element greater than largest stored
store the largest as second largest and store the element in largest
if the element is not greater than largest stored then check if second largest is greater than the element if not update it
time = O(N)
space = O(1)
*/

public class Solution {

    public static int[] getSecondOrderElements(int n, int []a) {
        int second_largest = secondLargest(n,a);
        int second_smallest = secondSmallest(n,a);
        int result[]= new int[2];
        result[0]=second_largest;
        result[1]=second_smallest;
        return result;
    }
    public static int secondLargest(int n, int []arr){
        int largest = arr[0];
        int second = -1;
        
        for(int nums: arr){
            if(nums>largest){
                second = largest;
                largest = nums;
            }
            else if(nums<largest && nums>second){
                second = nums;
            }
        }
        return second;
    }
    public static int secondSmallest(int n, int []arr){
        int smallest = arr[1];
        int second = arr[0];
        
        for(int nums: arr){
            if(nums<smallest){
                second = smallest;
                smallest = nums;
            }
            else if(nums>smallest && nums<second){
                second = nums;
            }
        }
        return second;
    }
}