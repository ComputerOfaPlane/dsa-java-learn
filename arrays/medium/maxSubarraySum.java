/*
given an array, find a subarray whose sum is maximum

brute:
run a nested loop to find boundaries of each sub array
within that boundaries run a loop to traverse the sub array and fins sum
if sum is higher store it
time =O(N^3)
space = O(1)

better:
run a nested loop but within the inner one calculate sum, if sum is higher store
time  = O(n^2)
space = O(1)

best: kadane algorithm
maintain two variables
one current sum
and the other is max
traverse the array
update the current sum, 
if max is less update max
if current sum is less than 0 update s=0
(note order of these if statements is important)
return the max
*/

class Solution {
    public int maxSubArray(int[] nums) {

        int s=0;
        int max=nums[0];

        /*// to print the sub array
        int start=-1;
        int anstart=-1;
        int ansend=-1;*/

        for(int i:nums){

            /*
                if(sum==0) start=i;
            */
            s+=i;
            if(max<s) max=s;
            /*
                {
                    anstart=start;
                    ansend=i;
                }
            */
            if(s<0) s=0;
        }
        return max;
    }
}
