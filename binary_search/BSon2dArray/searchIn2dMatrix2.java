/*
part 2
the rows are sorted and the columns are also sorted, but the last element of previous row is not smaller than the first element of next row

use the same concept of elimination of search space

time complexity = O(r+c)
*/
class part2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int i=0, j=c-1;
        while(i<r && j>=0){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]<target) i++;
            else j--; 
        }
        return false;
    }
}