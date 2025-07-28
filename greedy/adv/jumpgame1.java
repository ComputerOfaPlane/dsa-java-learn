class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true; // just one element
        if(nums[0]==0) return false; // first element is zero
        int zeros = -1, max = nums[0];
        for(int i=1; i<n-1; i++){ // running till 1 prev
            max = Math.max(max,nums[i]+i);
            if(nums[i]==0) zeros = i;
            if(max<=zeros) return false;
        }
        return true;
    }
}
// dp memo tech
class Solution {
    public boolean canJump(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        return is(0,nums,map);
    }
    static boolean is(int index, int nums[], Map<Integer,Boolean> map){
        if(map.containsKey(index)) return map.get(index);
        if(index==nums.length-1){
            map.put(index,true);
            return true;
        } 
        if(index>=nums.length || nums[index]==0){
            map.put(index,false);
            return false;
        } 
        int jumps = nums[index];
        for(int i=jumps; i>=1; i--){
            if(is(index+i,nums,map)){
                map.put(index,true);
                return true;
            }
        }
        map.put(index,false);
        return false;
    }
}