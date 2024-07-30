/*
finding the longest subarray with sum k

Brute Force:
we run nested loop to find the boundaries of the subarray 
then we traverse thru that subarray and find its sum to compare it with k
we store the max sum
for(int leftbounfd: 0 to n)
    for(int rightBound: i to n)
        int sum=0
        for(int i=leftbound;i<=rightbound; i++)
            sum+= subarray elements
        compare sum with k and store length if its greater
Time = ~O(n^3)
space = O(1)

Better Brute:
we run nested loop to find the boundaries of the subarray 
but we add the sum within it
so,
for(int leftbounfd: 0 to n)
    int sum=0
    for(int rightBound: i to n)
        sum+=arr elements
    compare sum with k and store length if its greater
Time = ~O(n^2)
space = O(1)

Better: (works for all +ve and -ve)
we use hashmap and store the sum after accesing each elements
we compare it with k if its equal we compare it with the stored length
calculate prefix sum = sum-k
if prefix sum exists in the map
find the sub array bounds and update length after comparing
if the sum doesnt exists in the map, add it (checking this because array may contain zeros)
(see code fn below)
Time = O(n)
Space  = O(1)

Best: (only for positives)
use two pointer approach 
keep a left pointer and a right pointer both starts at zeroth index
The sum is set to a[0] i.e. the first element initially.
Now we will run a while loop until the right pointer crosses the last index i.e. n-1.
Inside the loop, we will do the following:
    We will use another while loop and it will run until the sum is lesser or equal to k.
        Inside this second loop, from the sum, we will subtract the element that is pointed by the left pointer and increase the left pointer by 1.
    After this loop gets completed, we will check if the sum is equal to k. If it is, we will compare the length of the current subarray i.e. (right-left+1) with the existing one and consider the maximum one.
    Then we will move forward the right pointer by 1. If the right pointer is pointing to a valid index(< n) after the increment, we will add the element i.e. a[right] to the sum.
Finally, we will return the maximum length.
time = O(n) + O(n) // both pointers reach end
space = O(1)
*/
import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static int lenOfLongSubarr (int a[], int n, int k) {
        
        HashMap<Integer, Integer> m = new HashMap<>();
        
        int len=0, sum=0;
        
        for(int i=0;i<n;i++){
            sum+=a[i];
            
            if(sum==k) len=Math.max(len,i+1);
            
            int rem = sum-k;
            
            if(m.containsKey(rem)){
                int t=i-m.get(rem);
                len=Math.max(len,t);
            }
            if(!m.containsKey(sum)){
                m.put(sum,i);
            }
        }
        return len;
    }

    public static int longestSubarrayWithSumK(int []a, long k) {
        // only positives
        int n= a.length;
        int left =0, right=0;
        long sum=a[0];
        int len =0;

        while(right<n){

            while(left<=right && sum>k){
                sum-=a[left];
                left++;
            }
            int t=right - left + 1;
            if(sum==k){
                len = (len>t)?len:t;
            }
            right++;
            if(right<n) sum+=a[right];
        }
        return len;

        
        
    }
}