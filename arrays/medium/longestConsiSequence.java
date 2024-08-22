/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

brute:
run a loop for each element and linearly check for its next consecutive element
for (int i = 0; i < n; i++) {
    int x = a[i];
    int cnt = 1;
    while (linearSearch(a, x + 1) == true) {
        x += 1;
        cnt += 1;
    }

    longest = Math.max(longest, cnt);
}
time = O(n^2)
space= O(1)

better:
1. sort the array
2. traverse the array if the curr elm previous consecutive existed increment count and update prev
3. if prev is not equal to curr and above condition also fails reset count to 1 and update prev
4. update longest

maybe optimal:
use a set
1. add all elements to a set
2. iterate thru the set
3.      if set doesnt contain the prev consecutive elm then // start of consi sequence
            find if it contains next consecutive
        update longest
time = O(N) + O(N+N) = O(3N)
space = O(N)
*/
import java.util.*;

public class Solution {
    public static int longestSuccessiveElements(int []a) {
        int n=a.length;
        if(n==1) return 1;
        Arrays.sort(a);
        int longest=1;
        int lastsmol=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]-1==lastsmol){
                count++;
                lastsmol=a[i];
            }
            else if(lastsmol!=a[i]){
                count=1;
                lastsmol=a[i];
            }
            longest=Math.max(longest, count);
        }
        return longest;
    }
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n<=1) return n;
        Set<Integer> set=new HashSet<>();
        for(int i:nums) set.add(i);
        int longest=1;
        for(int i:set){
            if(!set.contains(i-1)){
                int count=1;
                int t=i;
                while(set.contains(t+1)){
                    count+=1;t+=1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}