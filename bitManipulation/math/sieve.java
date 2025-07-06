/*
marks all the non prime
*/
class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean notprime[] = new boolean[n];
        notprime[0] = true;
        notprime[1] = true;
        for(int i=2; i*i<n; i++){
            if(notprime[i]) continue;
            for(int j=i*i; j<n; j+=i) notprime[j] = true;
        }
        int c = 0;
        for(boolean b:notprime) if(!b) c+=1;
        return c;
    }
}