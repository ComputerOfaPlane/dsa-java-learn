/*
find the count of subarray which have an xor of k:

brute: iterate through all subarrays

optimal:
prefix sum based approach

<-----curr_xor-------->
. . . . . . . . . . . . . . . .
<--xor=b----> <--xor=k>

in this we can see curr xor = b ^ k
if we xor both side we get
b = curr^k

if curr^k occured previously count it

*/

public class Solution {

    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        int c = 0;
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        int xor = 0;
        for(int i=0; i<n; i++){
            xor^=a[i];
            if(xor==b) c++;
            int needed = xor^b;
            if(map.containsKey(needed)) c+=map.get(needed);
            if(map.containsKey(xor)) map.replace(xor,map.get(xor)+1);
            else map.put(xor,1);
        }
        return c;
    }

    public static int BrutesubarraysWithSumK(int []a, int b) {
        // Write your code here
        int c = 0;
        int n = a.length;
        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=i; j<n; j++){
                xor^=a[j];
                if(xor==b) c++;
            }
        }
        return c;
    }
}