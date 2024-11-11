/*
count subarrays with sum k

brute: O(n^3)
better: O(n^2)

optimal:
use prefix sums
    x-k             k 
 _____________ ___________
[. . . . . . . . . . . . . . . . . . .]
|------------------------>
            sum x

store sums and count in maps
time: O(N)
spcae = O(N)
*/

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int c = 0;
        map.put(0,1);
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            int rem = sum-k;
            if(map.containsKey(rem)){
                c+=map.get(rem);
            }
            if(map.containsKey(sum)) map.replace(sum,map.get(sum)+1);
            else map.put(sum,1);
        }
        return c;
    }
}