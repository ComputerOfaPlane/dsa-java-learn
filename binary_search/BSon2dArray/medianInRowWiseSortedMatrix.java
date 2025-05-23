/*
Given a row-wise sorted matrix where the number of rows and columns is always odd, find the median of the matrix.

Examples:

Input: mat = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 

Input: mat = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives us {1,2,3}. Hence, 2 is median

Input: mat = [[3], [5], [8]]
Output: 5
Explanation: Sorting matrix elements gives us {3,5,8}. Hence, 5 is median.

brute force:
approach can be combine all the elements in a linear data structure, and sort it, you have your median

optimal:

do binary search on answers

find the range of answers

then within binary search find how many elements will be to the left if the particular mid is chosen
*/
class Solution {
    int median(int mat[][]) {
        // code here
        int r = mat.length, c= mat[0].length;
        int left = mat[0][0], right = -1;
        for(int i=0; i<c; i++){
            left = Math.min(left,mat[i][0]);
            right = Math.max(right,mat[i][c-1]);
        }
        int half = (r*c)/2;
        while(left<=right){
            int mid = (left+right)/2;
            if(check(mat,mid,r,c)<=half) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
    static int check(int mat[][], int mid, int r, int c){
        int counter = 0;
        for(int i=0; i<r; i++){
            int left = 0, right = c-1;
            while(left<=right){
                int midi = (left+right)/2;
                if(mat[i][midi]>mid) right = midi-1;
                else left = midi+1;
            }
            counter+=left;
        }
        return counter;
    }
}