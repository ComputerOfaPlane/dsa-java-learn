/*
You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.

approach:

brute force: 

Input: stalls[] = [10, 1, 2, 7, 5], k = 3

we need to place three cows such that the distance between two cows is maximum

what we can do is run down all possible ways

lets first keep a minimum distance of 1 between all the cows, and see if we can place them in the stalls, 
keep the distance 2
then keep the distance 3
then keep the distance 4

after a particular distance we will see we can no more place all the cows in the stalls

so our answer will be the last valid

we get a range, left will be 1
as minimum distance between two cows will always be one

what will right be?
max position of the stall-min position of stall

*/
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int left = 1, right = stalls[n-1]-stalls[0];
        int max = Integer.MIN_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2; // distance between the cows
            if(check(stalls,mid,k,n)){
                max = Math.max(max,mid);
                left = mid+1;
            }
            else right = mid-1;
        }
        return max;
    }
    static boolean check(int stalls[], int distance, int k, int n){
        int prev = 0;
        int placed = 1;
        for(int i=1; i<n; i++){
            if(stalls[i]-stalls[prev]>=distance){
                prev = i;
                placed+=1;
            }
            if(placed==k) return true;
        }
        return false;
    }
}
