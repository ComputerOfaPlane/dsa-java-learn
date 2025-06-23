/*
count the number of subsequence that gives sum as target

this approach is TLE
*/
class Solution {
    public int perfectSum(int[] nums, int target) {
        return is(0,nums,0,target);
    }
    static int is(int index, int arr[], int curr, int sum){
        if(index==arr.length){
            if(curr==sum) return 1;
            return 0;
        }
        curr += arr[index];
        int ans = is(index+1, arr, curr, sum); // adds up all the answers
        curr -= arr[index];
        ans += is(index+1, arr, curr, sum);
        return ans;
    }
}