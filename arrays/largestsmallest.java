/*
Brute Force:
Sort the array, largest will be array[length-1]
Time = O(NlogN)
Space = O(1)

Better:
Store first element in a variable and compare it to every other element in the array
if a larger element is encountered, store it in the variable
Time = O(N)
Space = O(1)
*/

class Solution {
    
    public static int largest(int n, int[] arr) {
        
        if(n==1) return arr[0];

        int largest = arr[0];

        for(int i=1; i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }
}
