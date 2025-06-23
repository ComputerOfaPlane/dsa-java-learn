/*
return true if there exists a subsequence which gives a desired sum
*/
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        return is(0,arr,0,sum);
    }
    static boolean is(int index, int arr[], int curr, int sum){
        if(curr>sum) return false;
        if(index==arr.length){
            if(curr==sum) return true;
            return false;
        }
        curr += arr[index];
        if(is(index+1, arr, curr, sum)) return true; // notice the if block
        curr -= arr[index];
        if(is(index+1,arr,curr,sum)) return true; // notice the if block
        else return false;
    }
}