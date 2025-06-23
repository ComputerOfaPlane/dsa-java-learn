/*
basically mod exponentiation with some greedy observations
*/
class Solution {
    static int mod = 1_000_000_000 + 7;
    public int countGoodNumbers(long n) {
        if(n==1) return 5;
        n-=1;
        long evenplaces = n/2;
        long oddplaces = n - evenplaces;

        evenplaces = pow(5,evenplaces)%mod;
        oddplaces = pow(4,oddplaces)%mod;
        oddplaces = (oddplaces*evenplaces)%mod;
        return (int)((5*oddplaces)%mod);
    }
    static long pow(long x, long n){
        if(x==0 || x==1 || n==1) return x;
        if(n==0) return 1;
        if(n%2==0) return (pow((x*x)%mod,n/2))%mod;
        else return (x*(pow(x,n-1)%mod))%mod;
    }
}