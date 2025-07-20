/*
given a binary array, find all the subarrays with sum equal to goal

approach:

find all the subarrays with sum<=goal - find all the subarrays with sum<=goal-1
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        return lessequal(nums,n,goal)-lessequal(nums,n,goal-1);
        /*Map<Integer,Integer> map = new HashMap<>();
        int curr = 0, count = 0;
        for(int i:nums){
            curr += i;
            if(curr==goal) count+=1;
            int needed = curr - goal;
            if(map.containsKey(needed)) count += map.get(needed);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;*/
    }
    static int lessequal(int nums[], int n, int goal){
        if(goal<0) return 0;
        int left=0, right=0, ans=0, sum=0;
        while(right<n){
            sum += nums[right];
            while(sum>goal){
                sum -= nums[left];
                left += 1;
            }
            ans += (right-left+1);
            right+=1;
        }
        return ans;
    }
}