/*
right->bottom->left->top
keep a implementation based approach
time = O(n*m)
space = as required
*/
import java.util.*;
public class Solution {
    public static int[] spiralMatrix(int [][]MATRIX) {
        int n = MATRIX.length;
        int m = MATRIX[0].length;
        int arr[] = new int[n*m];
        int idx = 0;
        int top=0, left=0, right=m-1, bottom=n-1;

        while(left<=right && top<=bottom){
            // top left->top right
            for(int i=left; i<=right; i++){
                arr[idx++]=MATRIX[top][i];
            }
            top++;
            // top right->bottom right
            for(int i=top; i<=bottom; i++){
                arr[idx++]=MATRIX[i][right];
            }
            right--;

            if(top<=bottom){
                // bottom right -> bottom left
                for(int i=right; i>=left; i--){
                    arr[idx++]=MATRIX[bottom][i];
                }
                bottom--;
            }
                
            if(left<=right){
                // bottom left->top left
                for(int i=bottom; i>=top; i--){
                    arr[idx++]=MATRIX[i][left];
                }
                left++;
            }
        }
        return arr;
    }
}