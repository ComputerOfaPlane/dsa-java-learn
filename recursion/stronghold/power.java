/*
find x^n

trick to do it in logarithmic time complexity:

x^n = (x^2)^(n/2)

if n is odd then decrease n by 1 and multiply x to answer

*/
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x = 1.0/x;
            n = -n;
        }
        return pow(x,n);
    }
    static double pow(double x, int n){
        if(x==0.0 || x==1.0 || n==1) return x;
        if(n==0) return 1.0;
        if(n%2==0) return pow(x*x,n/2);
        else return x*pow(x,n-1);
    }
}