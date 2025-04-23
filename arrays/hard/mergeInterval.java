/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.

approach:
sort the array on basis of start, if there is a tie, tie breaker is the end interval
set the first interval as start and end
iterate from 1->n
curr start = s, end =e
if cuur start is greater than end => new interval add the start and end to ans and refresh start as s and end as e
else update end as maximum of end and e

approach 2:
have a prefix based approach
If the interval can be represented as [start,end] from the constraints we can see their sizes is at max 104. So we can just create and array of size 104, increment the start positions and decrement the end positions in our array.

As we traverse through our array calculating the array sum, when prefixSum==0 that means there were no intervals that covered this cell.

There is a special interval to note, when start==end, in this case there would be no effect as increment and decrement operation takes place on the same cell, so we can take another array that would store such cases.
*/
import java.util.*;
class Solution {

    //aproach 1
    public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        int n = arr.length;
        Arrays.sort(arr,(row1,row2)->{
            int cmp = Integer.compare(row1[0],row2[0]);
            return cmp==0?Integer.compare(row1[1],row2[1]):cmp;
        });
        List<List<Integer>> ans = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i=1; i<n; i++){
            int s = arr[i][0];
            int e = arr[i][1];
            if(s>end){
                ans.add(Arrays.asList(start,end));
                start = s;
                end = e;
            }
            else end=Math.max(end,e);
        }
        ans.add(Arrays.asList(start,end));
        return ans;
    }


    // approach 2
    public int[][] merge(int[][] intervals) {
        int period[] = new int[10001];
        boolean mark[] = new boolean[10001];
        List<List<Integer>> interval = new ArrayList<>();
        int len = -1;
        for(int q[]:intervals){
            int x = q[0], y = q[1];
            period[x]++;
            period[y]--;
            len = Math.max(len,Math.max(x,y));
            if(x==y) mark[x]=true;
        }
        int prefixsum=0;
        for(int i=0; i<=len;){
            prefixsum+=period[i];
            if(prefixsum>0){
                List<Integer> in = new ArrayList<>();
                in.add(i);
                mark[i]=false;
                i++;
                while(i<len && prefixsum>0){
                    prefixsum+=period[i];
                    i++;
                }
                if(prefixsum==0){
                    in.add(i-1);
                    mark[i-1]=false;
                } 
                else{
                    in.add(i);
                    mark[i]=false;
                } 
                interval.add(in);
            }
            else{
                boolean c1 = mark[i]==true;
                if(c1){
                    List<Integer> in = new ArrayList<>();
                    in.add(i);
                    in.add(i);
                    interval.add(in);
                }
                i++;
            }
        }
        // System.out.println(interval);
        int ans[][] = new int[interval.size()][2];
        for(int i=0; i<interval.size(); i++){
            ans[i][0] = interval.get(i).get(0);
            ans[i][1] = interval.get(i).get(1);
        }
        return ans;
    }
}