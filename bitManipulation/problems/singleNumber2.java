/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

brute force: hashing

approach better than hashing: (N*32)
for every bit position of all the numbers in the array
count the number of 1s,
if the count % 3 == 1, that particular bit position will be set for sure

more better: sort the array, and traverse through group heads

best: (unintuitive) use buckets
create two buckets initailized as 0
for each number in nums
add that number to bucket1 if it is not in bucket 2
add that number to bucket2 if it is not in bucket 1
return number in bucket1

*/
class Solution {
    public int singleNumber(int[] nums) {
        int bucket1 = 0, bucket2 = 0;
        for(int i:nums){
            bucket1 = (bucket1^i)&(~bucket2);
            bucket2 = (bucket2^i)&(~bucket1);
        }
        return bucket1;
    }
}

/*
better approach:
class Solution {
    public int singleNumber(int[] nums) {
        int number = 0;
        for(int i=0; i<32; i++){
            int c = 0;
            for(int j:nums){
                if((1&(j>>i))==1) c+=1;
            }
            if(c%3==1) number += 1<<i;
        }
        return number;
    }
}
*/