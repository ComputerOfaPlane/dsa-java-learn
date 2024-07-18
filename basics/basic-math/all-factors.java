import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution{

    public static List< Integer > printDivisors(int n) {

        List<Integer> l = new ArrayList<Integer>();

        for(int i=1;i*i<=n;i++){ // O(sqrt(n))
            if(n%i==0){
                l.add(i);
                int sec=n/i;
                if (sec!=i) l.add(sec);
            }
        }
        Collections.sort(l); // O(nlogn)
        return l;
    }
}
/*

// sum of factors from 1 to n

O(n)
class Solution{
    static long sumOfDivisors(int N){
        long sum=0;
        for(int i=1;i<=N;i++){
            sum+=i*(N/i);
        }
        return sum;
    }
}

*/