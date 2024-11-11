/*
rotate a matrix by 90*

Brute:
create a 2d array
time = O(n^2)
space = O(n^2)

better:
1. transpose
2. mirror/flip
time = O(n^2)
space = O(1)
*/
import java.util.*;
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix,n);
        mirror(matrix,n);
    }
    private static void transpose(int arr[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int t = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=t;
            }
        }
    }
    private static void mirror(int arr[][], int n){
        for(int i=0; i<n; i++){
            int left = 0, right = n-1;
            while(left<right){
                int t = arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=t;
                left++; right--;
            }
        }
    }
    public static void rotateMatrix(int [][]mat){
        int n = mat.length;
        int arr[][]=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[j][n-i-1]=mat[i][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mat[i][j]=arr[i][j];
            }
        }
    }
}