/*
find the left non overlapping interval
then find all the middle overlapping interval and merge them
then add all the right non overlapping interval
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n==0){
            int ret[][] = new int[1][2];
            ret[0][0] = newInterval[0];
            ret[0][1] = newInterval[1];
            return ret;
        }
        List<List<Integer>> list = new ArrayList<>();
        int j=0;
        // prev section no overlap
        while(j<n && intervals[j][1]<newInterval[0]){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[j][0]);
            temp.add(intervals[j][1]);
            list.add(temp);
            j+=1;
        }
        // next section no overlap
        int start = j;
        boolean did = false;
        // System.out.println(newInterval[1]+"<"+intervals[j][1]);
        while(j<n && ((newInterval[0]>=intervals[j][0] && newInterval[0]<=intervals[j][1]) || (newInterval[1]>=intervals[j][0] && newInterval[1]<=intervals[j][1]) || newInterval[1]>=intervals[j][0])){
            j+=1;
            did = true;
        } 
        // mid section overlap
        if(did){
            List<Integer> in = new ArrayList<>();
            // System.out.println(start+" "+j);
            in.add(Math.min(newInterval[0],intervals[start][0]));
            in.add(Math.max(newInterval[1],intervals[j-1][1]));
            list.add(in);
        }else{
            List<Integer> in = new ArrayList<>();
            // System.out.println(start+" "+j);
            in.add(newInterval[0]);
            in.add(newInterval[1]);
            list.add(in);
        }
        // nex
        for(int i=j; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            list.add(temp);
            // System.out.println("here");
        }
        int len = list.size();
        int ans[][] = new int[len][2];
        for(int i=0; i<len; i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}