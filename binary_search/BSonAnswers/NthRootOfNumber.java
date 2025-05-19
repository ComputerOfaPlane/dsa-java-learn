/*
find the nth root of a number m

basically m^(1/n) = ans

return -1, if ans is not an integer

suppose we need to find cube root of 125

we set left = 1, right = 124

in the loop we find out mid 62

multiply 62 n times, then it is a typical binary search

mid^n can be done in two ways:
1. iteratively multiply mid, n times
    sligth optimisation: if curr power exceeds m, terminate

doing mid^n can be simplified to a log n complexity

suppose we need to calculate 5^9

take three variables

ans = 1, base = mid, power = n;

5^9 can be written as 5*5^8

multiply the 5 to ans

ans = 5
base = 5, power = 8 => 5^8 it can be written as (5^2)^(8/2)

like this ans*base will give us the power
*/

public class Solution {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int left = 1, right = m-1;
        long num = m;
        while(left<=right){
            int mid = left+(right-left)/2;
            int mul =pow(mid,n, num);
            if(mul==1) return mid;
            else if(mul==0) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    static int pow(int x, int n, long m){
        long ans = 1L, base = x, power = n;
        while(power>1){
            if(power%2==1){
                ans *= base;
                power--;
            }
            else{
                base *= base;
                power = power/2;
            }
            if(ans*base > m) return 2;
        }
        return ans*base==m?1:0;
    }
}
/*
    static int pow(int x, int n){
        int ans = 1, base = x, power = n;
        while(power>1){
            if(power%2==1){
                ans *= base;
                power--;
            }
            else{
                base *= base;
                power = power/2;
            }
        }
        return ans*base;
    }
*/