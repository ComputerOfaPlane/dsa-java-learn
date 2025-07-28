// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        int i=0, j=0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int max = 1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                ans++;
                i++;
            }else{
                ans--;
                j++;
            }
            max = Math.max(ans,max);
        }
        return max;
    }
}
