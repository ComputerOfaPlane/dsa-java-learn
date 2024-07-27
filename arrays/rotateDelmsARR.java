import java.util.ArrayList;
/*
Brute force approach:

store the elements to be rotated
shift the rest of the elements 
put back the rest of the elements

time = O(d)+O(n-d)+O(d)
spcae = O(d)

Better approach:
reverse the array
reverse from 0 to k
reverse from k+1 to n
and reverse the entire array

time = O(2n)
space = O(1)

*/
public class Solution {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n=arr.size();
        k=k%n;
        int tmp[]=new int[k];
        for(int i=0; i<k; i++){
            tmp[i]=arr.get(i);
        }
        for(int i=k; i<n;i++){
            arr.set(i-k,arr.get(i));
        }
        for(int i=n-k; i<n;i++){
            arr.set(i,tmp[i-n+k]);
        }
        return arr;
    }
}
/*
right rotate
class Solution {
    public void rotate(int[] nums, int k) {

        int n=nums.length;
        k=k%n;
        
        // int tmp[]=new int[k];

        // for(int i=0;i<k;i++){
        //     tmp[i]=nums[n+i-k];
        // }
        // for(int i=n-1;i>=k;i--){
        //     nums[i]=nums[i-k];
        // }
        // for(int i=0;i<k;i++){
        //     nums[i]=tmp[i];
        // }
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
        
    }
    static void reverse(int arr[], int i, int j){
        while(i<j){
            swap(arr,i,j);
            i++;j--;
        }
    }
    static void swap(int arr[], int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
*/