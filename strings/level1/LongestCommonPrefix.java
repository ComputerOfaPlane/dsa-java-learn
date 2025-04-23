/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


my approach:

start with assuming a prefix lets say strs[0], if strs was length one then strs[0] would truly be a prefix
now iterate from index 1 of array to last
for each find the common prefix
update the prefix

*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            String s = strs[i];
            String add = "";
            int min = Math.min(s.length(),prefix.length());
            for(int j=0; j<min; j++){
                char ch1 = s.charAt(j);
                char ch2 = prefix.charAt(j);
                if(ch1==ch2){
                    add = add + ch1;
                }
                else break;
            }
            prefix = add;
        }
        return prefix;
    }
}