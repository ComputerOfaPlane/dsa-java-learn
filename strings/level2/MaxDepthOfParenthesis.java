/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

my approach:
if open parenthesis is encountered increment count
else if closing parenthesis is encountered decrement count
keep updating max
*/
class Solution {
    public int maxDepth(String s) {
        int count = 0, n = s.length(), max = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='(') count++;
            else if(ch==')') count--;
            max = Math.max(max,count);
        }
        return max;
    }
}