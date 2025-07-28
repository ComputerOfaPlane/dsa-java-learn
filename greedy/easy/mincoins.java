// User function Template for Java

class Solution {
    static List<Integer> minPartition(int N) {
        // code here
        int a[] =  { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int j = 9;
        List<Integer> list = new ArrayList<>();
        while(N>0){
            if(N>=a[j]){
                int nn = N/a[j];
                int rem = N%a[j];
                N = rem;
                for(int i=1; i<=nn; i++) list.add(a[j]);
            }
            j--;
        }
        return list;
    }
}