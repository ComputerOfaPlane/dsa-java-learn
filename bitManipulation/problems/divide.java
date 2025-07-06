/*
divide two numbers, do an integer divison and just return the integer part

brute force:
keep substracting divisor from dividend (TLE)

better: using bit manipulation

suppose divided = 20
divisor = 3

we keep finding the largest number that can be used to substract the dividend

3x2**2

quotation increases by 2
divided decreases by 12

and so on as long as dividend is greater than equal to divisor
*/
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean positive = true;
        if(dividend<0 && !(divisor<0)) positive = false;
        if(divisor<0 && !(dividend<0)) positive = false;
        long num = Math.abs((long)dividend);
        long den = Math.abs((long)divisor);
        int quote = 0;
        while(num>=den){
            long i=1, temp = den;
            while((temp<<1)<=num){
                i<<=1;
                temp<<=1;
            }
            quote+=i;
            num -= temp;
        }
        return positive?quote:-quote;
        // return dividend/divisor;
    }
}