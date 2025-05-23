/*
part1
you are given a 2d matrix, which have each row sorted and the last element of previous row is smaller than first element of next row

we can transform the 2d matrix as 1d array

row index = mid/c
col index = mid%c

*/
class part1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int left = 0, right = r*c - 1;
        while(left<=right){
            int mid = (right+left)/2;
            int num = matrix[mid/c][mid%c];
            if(num==target) return true;
            else if(num<target) left = mid+1;
            else right = mid-1;
        }
        return false;
        /*int r = matrix.length;
        int c = matrix[0].length;
        int left = 0, right = r-1, idx = -1;
        while(left<=right){
            int mid = (right+left)/2;
            if(matrix[mid][0]<=target){
                idx = mid;
                left = mid+1;
            }
            else right = mid - 1;
        }
        // System.out.println(idx);
        left = 0; right = c-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[idx][mid]==target) return true;
            else if(matrix[idx][mid]<target) left = mid+1;
            else right = mid-1;
        }
        return false;*/
    }
}