/*
longest subarray with two distinct elements

includes O(2N) to O(n) optimization
*/
class Solution {
    public int totalFruit(int[] arr) {

        int map[] = new int[100001]; // could have used a map here, it would take less space

        int distinct = 0, left = 0, right = 0, max = 0, n = arr.length;
        while(right<n){
            if(map[arr[right]]==0) distinct+=1;
            map[arr[right]]+=1;

            /*
            while(distinct>2){
                if(map[arr[left]]==1) distinct-=1;
                map[arr[left]]-=1;
                left+=1;
            }*/
            if(distinct>2){
                if(map[arr[left]]==1) distinct-=1;
                map[arr[left]]-=1;
                left+=1;
            }
            else max = Math.max(max,right-left+1);

            right+=1;
        }
        return max;
    }
}