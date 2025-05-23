/*
find peak element in a 2d matrix which is larger than the 4 adjacent cells

optimal:

remember how did we find peak in 1d array, we imagined array as mountain range and shifted towards the higher mountain

similarly

we would find a mid normally

then we would find the max element in that mid column, and check for mid

then  adjust search space if needed
*/
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int left =0, right = c-1;
        while(left<=right){
            int mid = (left+right)/2;
            int max = -1, idx = -1;
            for(int i=0; i<r; i++){
                if(max<mat[i][mid]){
                    max = mat[i][mid];
                    idx = i;
                }
            }
            int leftof = mid-1<0?-1:mat[idx][mid-1];
            int rightof = mid+1<c?mat[idx][mid+1]:-1;
            if(mat[idx][mid]>leftof && mat[idx][mid]>rightof) return new int[]{idx,mid};
            else if(mat[idx][mid]<leftof) right = mid-1;
            else left = mid+1;
        }
        return new int[]{-1,-1};
    }
}