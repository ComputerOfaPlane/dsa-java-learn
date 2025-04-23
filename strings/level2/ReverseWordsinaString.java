/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

my approach:

extract each word and keep inserting it at the begining, making sure the word is not null
*/

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch!=' ') word.append(ch);
            else if(word.length()>0){
                word.append(' ');
                sb.insert(0,word);
                word = new StringBuilder();
            }
        }
        word.append(' ');
        sb.insert(0,word);
        String ans = new String(sb);
        ans = ans.trim();
        return ans;
    }
}