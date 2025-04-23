/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

    For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:

Input: s = "abcde", goal = "abced"
Output: false


my approach:
imagine the string is circular, after going from last index we can go to first index
now search for the orginal string in this circular string

we can achieve this circular property by either %modulo or just adding the orginal string to itself
*/
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        int n = s.length();
        if(n!=goal.length()) return false;
        s+=s;
        return s.contains(goal);
    }
}