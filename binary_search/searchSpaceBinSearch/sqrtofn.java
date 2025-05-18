/*
find the square root of a number just the integer part

approach:

this is a pattern, 
1. here we know that the answer exists in a particular range

therefore we need to find the max number which num*num<=number holds true for this

find mid, if mid*mid<=number
            this means all the number to the left are not possible, as they will be even smaller than mid
          else
            this means all the number to the right are not possible as they are way bigger than required

eventually the right pointer will point to the sqrt

*/
class Solution {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int left = 1, right = x-1;
        while(left<=right){
            int mid =left+(right-left)/2;
            if((long)(1L*mid*mid)<=(long)x) left = left+1;
            else right = mid-1;
        }
        return right;
    }
}