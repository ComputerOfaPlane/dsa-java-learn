/*
sort by ascending end time, primary
then sort by descending start time
*/
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int pair[][] = new int[n][2];
        for(int i=0; i<n; i++){
            pair[i][0] = start[i];
            pair[i][1] = end[i];
        }
        Arrays.sort(pair,(a,b)->{
            int ret = Integer.compare(a[1],b[1]);
            return ret==0?Integer.compare(b[0],a[0]):ret;
        });
        int count = 1;
        int prev = pair[0][1];
        for(int i=1; i<n; i++){
            if(prev<pair[i][0]){
                // System.out.println(pair[i][0]+" "+pair[i][1]);
                count+=1;
                prev = pair[i][1];
            }
        }
        return count;
    }
}
