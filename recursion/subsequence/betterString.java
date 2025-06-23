/*
Given a pair of strings s1 and s2 of equal lengths, your task is to find which of the two strings has more distinct subsequences. If both strings have the same number of distinct subsequences, return s1.

Examples:

Input: s1 = "gfg", s2 = "ggg"
Output: "gfg"
Explanation: "gfg" have 6 distinct subsequences whereas "ggg" have 3 distinct subsequences. 

Input: s1 = "a", s2 = "b"
Output: "a"
Explanation: Both the strings have only 1 distinct subsequence.

approach: find subsequence of both the string and store them in a set

it gives tle
*/
class Solution {
    public static String betterString(String s1, String s2) {
        // Code here
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        generate(0,s1.length(),set1,"",s1);
        generate(0,s2.length(),set2,"",s2);
        
        if(set1.size()==set2.size() || set1.size()>set2.size()) return s1;
        return s2;
        
    }
    static void generate(int index, int length, Set<String> set, String s, String str){
        if(index==length){
            set.add(s);
            return;
        }
        generate(index+1, length, set, s+str.charAt(index),str);
        generate(index+1, length, set, s,str);
    }
}