/*
given an array of walls, where each wall take walls[i] time to completely paint it

there are k workers available to paint them

partition the walls in subarrays such that the worker with the most work time is minimized

this is the same as book allocation problem if we just copy and paste the code it will just work fine!

*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = -1, right = 0;
        for(int i:nums){
            left = Math.max(left,i);
            right+=i;
        }
        while(left<=right){
            int mid = (right+left)/2, count = 0, curr = 0;
            for(int i:nums){
                if(i+curr<=mid) curr+=i;
                else{
                    curr = i;
                    count++;
                }
            }
            count++;
            if(count<=k) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}