/*
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

    For example, the beauty of "abaacc" is 3 - 1 = 2.

Given a string s, return the sum of beauty of all of its substrings.

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.

Example 2:

Input: s = "aabcbaa"
Output: 17

my approach, iterate through all substring, and find each of its beauty, just reduced that to O(n^2) instead of O(n^3)

*/
class Solution {
    public int beautySum(String s) {
        int n = s.length(), beauty=0;
        for(int i=0; i<n; i++){
            int map[] = new int[26];
            for(int j=i; j<n; j++){
                map[s.charAt(j)-'a']++;
                beauty += beauty(map);
            }
        }
        return beauty;
    }
    static int beauty(int map[]){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i:map){
            if(i==0) continue;
            max = Math.max(i,max);
            min = Math.min(i,min);
        }
        return max-min;
    }
}