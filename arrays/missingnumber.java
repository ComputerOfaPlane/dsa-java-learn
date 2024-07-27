/*
Find missing number in an array
[1,8,6,3,5,2,7,4] 9 is missing array size n-1

Brute Force:
traverse for 1 to N
    for every traversal linearly search the element
    if found break
time = O(n^2)
space = O(1)

better:
hashing
create a visited array of length n
traverse the array and for every element mark it 1 in visited array
use hashmap if needed
time = O(N) to fill the map + O(N) to find missing
space = O(N)

optimal:
1. find the sum of n natural numbers by formula and 
traverse the array and substract the sum
return sum
sum may probably need long
time = O(N)
space = O(1)
2. xor
same number xored gives 0
any number xored with 0 gives number itself
    1 2 3 4 5 6 7 8 9
    1 2 3   5 6 7 8 9
xor 0 0 0 4 0 0 0 0 0
so find xor of n numbers
and xor of array elements
return the xor of both of them
time = O(N)
space = O(1)
*/

public class Solution {
    public static int missingNumber(int []a, int N) {
        
        /* int sum = N*(N+1)/2;

        for(int i=0; i<N;i++){
            sum-=a[i];
        }
        return sum; */

        int xor1 = 0;
        int xor2 = 0;

        for(int i=0; i<N;i++){
            xor1^=(i+1);
            xor2^=a[i];
        }

        return xor1^xor2;
    }
}