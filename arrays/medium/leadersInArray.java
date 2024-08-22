/*
Given an array arr of n positive integers, your task is to find all the leaders in the array. 
An element of the array is considered a leader if it is greater than all the elements on its right side or 
if it is equal to the maximum element on its right side. 
The rightmost element is always a leader.

brute:
run a nested loop
time= ~O(n^2)
space= no extra space is needed to find them but space is needed to store them

better:
1. use a variable max which stores the minimum value
2. traverse array from the back
time = O(N) to find leaders + // some more time if required
space = no extra space is needed to find them but space is needed to store them
*/
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> list=new ArrayList<>();
        int max=arr[n-1]-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=max){
                list.add(arr[i]);
            }
            max=Math.max(max,arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}