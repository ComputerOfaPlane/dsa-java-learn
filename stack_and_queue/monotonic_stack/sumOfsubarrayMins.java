/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Input: arr = [11,81,94,43,3]
Output: 444

brute force is simple: traverse all the subarrays

optimal:

use the concept of next smaller elements and previous smaller elements

for array
lets try to understand the contribution of each element

for contribution of 3
   ____________
[1, 4, 6, 7, 3, 7, 8, 1]
             --------
number of subarrays = 4 x 3 = 12
total contribution = 12 x element = 36

like this we will do for all the elements

there are also a lot of edge cases
*/
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_000 + 7, n = arr.length;
        long ans = 0L;
        int nse[] = nse(arr,n);
        int pse[] = pse(arr,n);
        // System.out.println(Arrays.toString(nse));
        // System.out.println(Arrays.toString(pse));
        for(int i=0; i<n; i++){
            int left = i-pse[i];
            int right = nse[i] - i;
            // System.out.println("elm = "+arr[i]+", left = "+left+", right = "+right);
            ans = ( ans + (1L*left*right*arr[i])%mod)%mod;
        }
        return (int)ans;
        /*
        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                min = Math.min(min,arr[j]);
                ans = (ans+min)%mod;
            }
        }
        return ans;*/
    }
    static int[] nse(int a[], int n){
        Stack<Integer> stack = new Stack<>();
        int nse[] = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && a[i]<=a[stack.peek()]) stack.pop();
            nse[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return nse;
    }
    static int[] pse(int a[], int n){
        Stack<Integer> stack = new Stack<>();
        int pse[] = new int[n];
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && a[i]<a[stack.peek()]) stack.pop();
            pse[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return pse;
    }
}
