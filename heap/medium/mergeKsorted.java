class Solution {
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i[]:arr){
            for(int j:i) pq.add(j);
        }
        while(!pq.isEmpty()) list.add(pq.poll());
        return list;
    }
}