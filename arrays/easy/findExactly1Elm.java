/*
find element that occurs exactly one time in the array
while rest occurs twice

brute force:
for every element in the array, find its frequency by traversing
if freq is one return
time = O(n^2)
space = O(1)

better:
create a map and store frequency of each element
traverse the keys of the map and find the element with unit freq
time = O(2n)
space = O(n)

optimal:
use xor
xor the entire array
because same element will cancel out
time = O(n)
space = O(1)

*/
public class Solution {

    public static int getSingleElement(int []arr){
        
        int xor = 0;

        int n=arr.length;

        for(int i=0;i<n;i++){
            xor^=arr[i];
        }
        return xor;
    }
}