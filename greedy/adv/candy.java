/*
optimal: in this we just need to find the number of candies to be distributed,we can visualise the ratings and line graph valleys

if staying at same slope, add 1
if up slope, remember the peak, and go up
else down slope, remember the max down, and add
*/

/*
not optimal
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, sum = 0; 
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        for(int i=1; i<n; i++){ // move left to right
            if(ratings[i-1]<ratings[i]) ans[i] = ans[i-1]+1;
        }
        for(int i=n-2; i>=0; i--){ // move right to left
            if(ratings[i+1]<ratings[i]) ans[i] = Math.max(ans[i+1]+1, ans[i]);
        }
        for(int i:ans) sum+=i;
        return sum;
    }
}
*/