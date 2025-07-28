class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;
        double arr[][] = new double[n][3];
        for(int i=0; i<n; i++){
            arr[i][0] = values[i];
            arr[i][1] = weights[i];
            arr[i][2] = arr[i][0]/arr[i][1];
        }
        Arrays.sort(arr,(a,b)->{
            return Double.compare(b[2],a[2]);
        });
        int i=0;
        double ans = 0.0;
        while(i<n && W>0){
            double value = arr[i][0];
            double weight = arr[i][1];
            double profit = arr[i][2];
            ans += (profit*Math.min(weight,W));
            W-=Math.min(weight,W);
            i+=1;
        }
        return ans;
    }
}