/*
need to remove the outer most parenthesis in a given string

A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

    For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

my approach:

if open parenthesis encountered 
    increment count
    if count is not zero (means not the outermost) append the character in the resultant string
else
    decrement count
    if count is not one (means not the outermost) append the character in the resultant string


*/
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), c=0;
        for(int i=0; i<n; i++){
            char ch= s.charAt(i);
            if(ch=='('){
                if(c!=0) sb.append(ch);
                c++;
            }
            else{
                if(c!=1) sb.append(ch);
                c--;
            }
        }
        return new String(sb);
    }
}