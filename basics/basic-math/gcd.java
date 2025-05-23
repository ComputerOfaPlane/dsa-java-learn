
public class Solution {
    
    public static int gcd(int a,int b)
    {
        while(a>0 && b>0){
            if (a>b) a=a%b;
            else b=b%a;
        }

        return (a==0)?b:a;
    }       
}
// time = O(log_phi(min(a,b)))