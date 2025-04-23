/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

my approach: just match the frequency of each character of both the strings
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length()-t.length();
        if(n!=0) return false;
        n = s.length();
        int map[] = new int[26];
        for(int i=0; i<n; i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for(int i:map) if(i!=0) return false;
        return true;
    }
}