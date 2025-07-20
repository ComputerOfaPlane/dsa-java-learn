/*
find the number of subarrays with exactly k distinct integers

same template as binary array sum is goal problem

count <=goal - count < goal
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return lessequal(nums,n,k)-lessequal(nums,n,k-1);
    }
    static int lessequal(int nums[], int n, int goal){
        if(goal<0) return 0;
        int left=0, right=0, ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>goal){
                map.replace(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left += 1;
            }
            ans += (right-left+1);
            right+=1;
        }
        return ans;
    }
}