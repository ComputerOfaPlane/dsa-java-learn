/*
same as binary array sum equal goal
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return lessequal(nums,n,k)-lessequal(nums,n,k-1);
    }
    static int lessequal(int nums[], int n, int goal){
        if(goal<0) return 0;
        int left=0, right=0, ans=0, sum=0;
        while(right<n){
            sum += (nums[right]&1)==1?1:0;
            while(sum>goal){
                sum -= (nums[left]&1)==1?1:0;
                left += 1;
            }
            ans += (right-left+1);
            right+=1;
        }
        System.out.println(ans);
        return ans;
    }
}