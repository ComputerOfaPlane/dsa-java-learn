class Solution {
    static int solve(int bt[]) {
        // code here
        int n = bt.length, time = 0, sum = 0;
        Arrays.sort(bt);
        for(int i=0; i<n-1; i++){
            sum+=bt[i];
            time+=sum;
        }
        return time/n;
    }
}