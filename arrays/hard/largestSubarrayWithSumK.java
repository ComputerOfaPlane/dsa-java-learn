/*
we need to find the largest subarray with sum k

brute:
iterate over all subarrays

optimal:
have a prefix sum approach
<__Curr_sum__________>
. . . . . . . . . . . . . . . . . .
^---s---^ ^---target--^
we are storing the current sums after each iterations, 
needed = curr - target
if needed had occured in the array we get our subarray
*/

import java.util.*;

public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.
        int target = 0, sum=0, max = 0, n=arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum==target) max = Math.max(max,i+1);
            int needed = sum-target;
            if(map.containsKey(needed)) max = Math.max(i-map.get(needed),max);
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}