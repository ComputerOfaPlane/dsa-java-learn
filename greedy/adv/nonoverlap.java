class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            int ret = Integer.compare(a[1],b[1]);
            return ret==0?Integer.compare(b[0],a[0]):ret;
        });
        int n = intervals.length, prev = intervals[0][1], count = 0;
        for(int i=1; i<n; i++){
            if(prev<=intervals[i][0]) prev = intervals[i][1];
            else count+=1;
        }
        return count;
    }
}