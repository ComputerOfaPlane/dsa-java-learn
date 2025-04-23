/*
conver string to integer with endless edge cases, uffff

https://leetcode.com/problems/string-to-integer-atoi/
*/
class Solution {
    public int myAtoi(String s) {

        int n = 0; // stores answer
        int readptr = 0; // string read pointer
        boolean positive = true; // positive flag
        s = s.trim(); // remove leading whitespaces
        int len = s.length(); // length of string after trimming

        // if length of string is zero
        if(len==0) return 0;

        // first char of string
        char first = s.charAt(0);

        // accounting for positive and negative
        if(first=='-') positive = false;

        // remove leading zeros
        if(first=='+'||first=='-') readptr = 1; // initialize start read ptr
        while(readptr<len && s.charAt(readptr)=='0') readptr++; // remove leading zeros

        int max = Integer.MAX_VALUE/10; // constraint to n

        // find answer
        for(int i=readptr; i<len; i++){
            char digit = s.charAt(i); // read char
            if(digit>='0'&&digit<='9'){ // is digit check
                boolean overflow = n>max || (n==max && (digit-'0')>Integer.MAX_VALUE%10);
                if(overflow) return (positive)?Integer.MAX_VALUE:Integer.MIN_VALUE;
                n = n*10 + (digit-'0');
            }
            else break;
        }

        return (positive)?n:-n;
    }
}