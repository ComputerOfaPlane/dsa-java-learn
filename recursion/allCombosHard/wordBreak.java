/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


similar to pallindrome partitioning
we try to find the partitioned string in the dictionary, if the string is found, accept the partition
and recurse of the remaining string

but to optimise we use memoization
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String t:wordDict) set.add(t);
        return ans(s,set,new HashSet<>());
    }
    static boolean ans(String s, Set<String> set, Set<String> map){
        if(s.length()==0) return true;
        for(int i=0; i<s.length(); i++){
            String x = s.substring(0,i+1);
            if(set.contains(x)){
                String xx = s.substring(i+1);
                if(!map.contains(xx) && ans(xx,set,map)) return true;
                else map.add(xx);
            }
        }
        return false;
    }
}