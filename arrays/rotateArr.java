import java.util.* ;
import java.io.*; 

/*
left rotate by 1 means
[1,2,3,4,5,6] => [2,3,4,5,6,1]

approach:
store the element
shilf the rest
put back the element

time = O(n)

*/
public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        
        int tmp = arr[0];

        for(int i=1; i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=tmp;

        return arr;

    }
}
// space = o(1) for extra space
// while its o(n) to return