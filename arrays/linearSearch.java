/*
Traverse the entire array to find the element 
time = O(n)
space = O(1)
*/
import java.util.*;
public class Solution {
    public static int linearSearch(int n, int num, int []arr){
        for(int i=0;i<n;i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }
}