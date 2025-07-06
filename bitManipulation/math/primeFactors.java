/*
Given a number n. Find its unique prime factors in increasing order.

Input: n = 100
Output: [2, 5]
Explanation: Unique prime factors of 100 are 2 and 5.

Input: n = 60
Output: [2, 3, 5]
Explanation: Prime factors of 60 are 2, 2, 3, 5. Unique prime factors are 2, 3 and 5.

approaches: 

1. we can find all the divisors, if it is a divisor, we check for prime and if yes we add it to the list
2. use the observations made in finding divisors i & n/i are the divisors, check both for prime and if yes add it  to list 

3. find the divisor in sqrt time
   keep dividing the number until it can divide it
   move on
*/
class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        int limit = (int)Math.sqrt(n);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                list.add(i);
                while(n%i==0) n=n/i;
            }
        }
        if(n!=1) list.add(n);
        return list;
    }
}
/*
using sieve to find the the prime factors
*/
class Solution {
    // You must implement this function
    static List<Integer> list = new ArrayList<>();
    static void sieve() {
        if(!(list.size()==0)) return;
        int len = 2*100_000+1;
        boolean notprime[] = new boolean[len];
        notprime[0] = true;
        notprime[1] = true;
        for(int i=2;i*i<len; i++){
            if(notprime[i]) continue;
            for(int j=i*i; j<len; j+=i) notprime[j] = true;
        }
        for(int i=0; i<len; i++) if(!notprime[i]) list.add(i);
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        while(list.get(index)*list.get(index)<=N){
            if(N%list.get(index)!=0){
                index++;
                continue;
            }
            while(N%list.get(index)==0){
                ans.add(list.get(index));
                N=N/list.get(index);
            }
            index+=1;
        }
        if(N!=1) ans.add(N);
        return ans;
    }
}