/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


here we want to find the minimum bananas destroyed per hour that finishes all bananas within h hours

observation:
lets start from one and go all the way to infinity for example 1

bdph:
1 - will take sum of array time >> h, not possible
2 - not possible
3 - not possible
4 - possible, we can finish in hours <= h
5 - possible
.
.
.
10 - possible
11 - possible, in array size time
12 - possible, in array size time
13 - possible, in array size time

we can see that there is a patter, after some particular dps, it is always possible and after the max element is reached in bps, no change is dps is obs
this gives us a range of answers through which we need to search
we can apply binary search
left =1, right = max element
for mid, calculate the time needed
if it is within h, remove the right search space
else remove the left search space as it signifies hours needed is still bigger than h
...
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = -1, left = 1;
        for(int i:piles) right = Math.max(right,i);
        while(left<right){
            int mid = left + (right-left)/2; // bana eating speed per hour
            int time = 0;
            for(int i:piles) time += (i+mid-1)/mid;
            if(time<=h) right = mid;
            else left = mid+1;
        }
        return left;
    }
}