/*
find row with maximum number of 1s

*/
class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int max = -1, idx = -1;
        for(int i=0; i<r; i++){
            Arrays.sort(mat[i]);
            int left = 0, right = c-1, size = 0;
            while(left<=right){
                int mid = (right+left)/2;
                if(mat[i][mid]==1){
                    size = c-mid;
                    right = mid-1;
                }
                else left = mid+1;
            }
            if(size>max){
                idx = i;
                max = size;
            }
        }
        return new int[]{idx,max};
    }
}