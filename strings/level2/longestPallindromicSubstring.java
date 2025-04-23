/*
Given a string s, return the longest pallindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

my approach,

start from first character in s
expand on both side assuming pallindromic substring is even
do same for odd length
*/
class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 1, n = s.length();
        String maxs = ""+s.charAt(0);
        for(int i=0; i<n; i++){
            // even letters
            String even = expandeven(s,i,n);
            // odd letters
            String odd = expandodd(s,i,n);

            int tempmax = -1;
            String temps = "";
            if(even.length()>odd.length()){
                tempmax = even.length();
                temps = even;
            }else{
                tempmax = odd.length();
                temps = odd;
            }
            if(tempmax>maxlen){
                maxlen = tempmax;
                maxs = temps;
            }
            if(maxlen==n) break;
        }
        return maxs;
    }
    static String expandeven(String s, int i, int n){
        int left = i, right = i+1;
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    static String expandodd(String s, int i, int n){
        int left = i-1, right = i+1;
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}