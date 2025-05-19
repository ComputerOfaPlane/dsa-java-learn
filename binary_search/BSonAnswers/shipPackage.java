/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

observation: minimum capacity of the ship must be atleast the max of the element so it does not take infinite days
             maximum capacity of the ship can be infinity which will let it ship in one day, or just the sum of the array

now do binary search of the range to find minimum capacity that can transfer payload
*/
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = -1, right = 0;
        for(int i:weights){
            right+=i;
            left = Math.max(left,i);
        }
        // System.out.println(right+" = sum");
        while(left<right){
            int mid = left + (right-left)/2; // max capacity 
            int count = 0, curr = 0;
            for(int i:weights){
                if(curr+i<=mid) curr+=i;
                else{
                    curr = i;
                    count++;
                }
            }
            if(curr>0) count++;
            // System.out.println(mid+" "+count);
            // System.out.println(left+" "+mid+" "+right);
            if(count<=days) right = mid;
            else left = mid+1;
        }
        return right;
    }
}