/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

have a sliding window approach

hash the index of the position where the particular character last occured
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, n = s.length(), max = 0;

        int map[] = new int[256]; // i am hashing frequencies, i could have hashed index for a better linear time complexity
        
        while(right<n){
            char ch = s.charAt(right);
            map[ch]+=1;
            while(map[ch]!=1){
                map[s.charAt(left)]-=1;
                left+=1;
            }
            max = Math.max(max,right-left+1);
            right+=1;
        }
        return max;
    }
}