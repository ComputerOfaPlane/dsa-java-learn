/*
We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1], where n is the size of the stations array. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations, is minimized. We have to find the smallest possible value of d. Find the answer exactly to 2 decimal places.
Note: stations is in a strictly increasing order.

Example 1:

Input:
n = 10
stations[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
k = 9
Output: 0.50
Explanation: Each of the 9 stations can be added mid way between all the existing adjacent stations.

Example 2:

Input:
n = 10
stations[] = [3, 6, 12, 19, 33, 44, 67, 72, 89, 95] 
k = 2 
Output: 14.00 
Explanation: Construction of gas stations at 8th(between 72 and 89) and 6th(between 44 and 67) locations.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findSmallestMaxDist() which takes a list of stations and integer k as inputs and returns the smallest possible value of d. Find the answer exactly to 2 decimal places.

brute force, approach:

we need to place k stations, on the number line such that the max distance between two stations is minimized

greedy choices:
1. it does not make sense to put new stations outside of the line

so we need to put the new stations between old stations

for each new station calculate the max distance between the stations,

the max distance would need to be minimized, so we place our new station between the two old station with max distance

also keep track where you are adding new stations to be able to calculate the new distances

better: use a maxheap to find maximum distance and update it

optimal: use binary search

// i failed to code the binary search code will look onto it later
*/
// User function Template for Java
// User function Template for Java

class Better {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        PriorityQueue<Pair<Double,Integer>> pq = new PriorityQueue<>((a, b)->{
            int ans = Double.compare(b.first(),a.first());
            return ans==0?Integer.compare(b.second(),a.second()):ans;
        });
        int n = stations.length;
        int gaps[] = new int[n-1];
        for(int i=0; i<n-1; i++) pq.add(new Pair<>(stations[i+1]-stations[i]+0.0,i));
        for(int i=1; i<=k; i++){
            Pair<Double, Integer> pair = pq.poll();
            int idx = pair.second(); double max = pair.first();
            gaps[idx]++;
            double diff = (stations[idx+1]-stations[idx]+0.0)/(gaps[idx]+1.0);
            pq.add(new Pair<>(diff,idx));
        }
        return pq.poll().first();
    }
    static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K first(){
            return key;
        }
        public V second() {
            return value;
        }
    }
}
class BruteForce {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        int gaps[] = new int[n-1];
        for(int i=1; i<=k; i++){
            int idx = -1; double max = -1;
            for(int j=0; j<n-1; j++){
                double diff = (stations[j+1]-stations[j])/(gaps[j]+1.0);
                if(diff>max){
                    idx = j;
                    max = diff;
                }
            }
            gaps[idx]++;
        }
        double ans = -1.0;
        for(int i=0; i<n-1; i++){
            ans = Math.max(ans, (stations[i+1]-stations[i])/(gaps[i]+1.0));
        }
        return ans;
    }
}