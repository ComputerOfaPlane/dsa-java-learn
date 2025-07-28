// greedy
/*
mark left and right, between left and right find out, through which index you can reach the farthest
*/
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int n = nums.length, left=0, right = 0, jump = 0;
        while(right<(n-1)){
            int max = -1, idx = -1;
            jump+=1;
            for(int i=left; i<=right; i++){
                if((max+idx)<(nums[i]+i)){
                    idx= i;
                    max = nums[i];
                }
            }
            left = idx+1;
            right = idx+max;
            // System.out.println(left+" "+right);
        }
        return jump;
    }
}

// memoization
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return is(0,nums,dp);
    }
    static int is(int index, int nums[], int dp[]){
        if(index==nums.length-1) return 0;
        if(index>=nums.length || nums[index]==0) return Integer.MAX_VALUE;
        if(dp[index]!=-1) return dp[index];
        int min = Integer.MAX_VALUE, jumps = nums[index];
        for(int i=1; i<=jumps; i++){
            int ret = is(index+i,nums,dp);
            if(ret!=Integer.MAX_VALUE) min = Math.min(min,1+ret);
        }
        dp[index] = min;
        return min;
    }
}

// recursive backtracking
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        // Map<Integer,Integer> map = new HashMap<>();
        return is(0,nums,0);
    }
    // static int is(int index, int nums[], Map<Integer,Integer> map, int counter){
        
    // }
    static int is(int index, int nums[], int counter){
        if(index==nums.length-1) return counter;
        if(index>=nums.length || nums[index]==0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE, jumps = nums[index];
        for(int i=1; i<=jumps; i++){
            int ret = is(index+i,nums,counter+1);
            min = Math.min(min,ret);
        }
        return min;
    }
}