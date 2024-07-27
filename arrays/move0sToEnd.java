/*
Brute force approach:
[1,0,3,0,0,5,6,9,0,5,0,6,6]
copy non zero elements to an temporary array, (or indexes)
then copy them back to the original array and make the rest of the elements 0s
time = O(n) to find and store all non zero elements + O(n) to copy back = O(2n)
space = O(n)

better:
2 pointer approach
find the index of first 0 and make one variable point to it
place the next pointer at the next index
compare value at non zero pointer if non zero then swap with the other and increase zero pointer by one
Time = O(n)
Space = O(1)

*/

public class Solution {
        public static int[] moveZeros(int n, int []a) {
        
        int j=-1;
        for(int i=0;i<n;i++){
            if(a[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return a;
        int i=j+1;
        while(i<n){
            if(a[i]!=0){
                swap(a, i, j);
                j++;
            }
            i++;
        }
        return a;
    }
    static void swap(int arr[], int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}