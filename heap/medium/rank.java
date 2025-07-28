/*
replace elements by its rank

Input:
N = 6
arr = [20, 15, 26, 2, 98, 6]
Output:
4, 3, 5, 1, 6, 2
*/
class Solution {
    static int[] replaceWithRank(int arr[], int n) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(arr[a],arr[b]));
        for(int i=0; i<n; i++){
            pq.add(i);
        }
        int rank = 1;
        int prev = -999;
        while(!pq.isEmpty()){
            int i = pq.poll();
            int curr = arr[i];
            if(prev==curr){
                arr[i] = rank-1;
            }
            else{
                arr[i] = rank++;
            }
            prev = curr;
        }
        return arr;
    }
}
