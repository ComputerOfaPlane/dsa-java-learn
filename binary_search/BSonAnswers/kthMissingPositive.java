/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

brute force: there is a number of brute force solutions

but most clean way is: 

for(int i:arr){
    if(i<=k) k++;
    else break;
}

optimal way of doing it:

the problem here is to figure out the internal range between which our solution would exist

lets take example 1
missing numbers at each index
  1  2  3  4   5    this should be the array without missing
[ 2, 3, 4, 7, 11]
  1  1  1  3   6    these are the numbers that are missing at each index.

now we can do binary search of k

right will point to interval end
left will point to interval start

answer will be arr[right]+k-(arr[right]+(high+1))
this simplifies to right+k+1 or left+k is the answer

*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k) left = mid+1;
            else right = mid-1;
        }
        return left+k;
    }
}