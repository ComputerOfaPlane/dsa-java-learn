/*
Problem: we have two sorted arrays a[] and b[] of length m and n respectively, we need to merge both of them without using extra space
eg: a=[1,3,5,7]
    b=[2,4,6]
after merge
a=[1,2,3,4] b=[5,6,7]

approach: we can do it using two pointers and a extra space of n+m

approach2 (no extra space): place a pointer on the largest element of one array and another pointer at the smallest element of another array
if pointer element of first element is bigger than the pointer element at second array, swap both of them, if false then break
then sort the 2 arrays

approach 3(no space): initialize a gap = (n+m)/2 ceil division
imagine both arrays side by side, place one pointer at 0, other at pointer1+gap
[. . . . . .][. . .]
 ^ __+gap__^
now run a loop until gap is zero
swap elements at both the pointers if pointer1 elm is greater than pointer2 elm
do ceil div gap/2
*/
import java.util.*;
public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int n = a.length;
        int m = b.length;
        int len = n+m;
        int gap = (len+1)/2;
        while(gap>0){
            int i=0, j=i+gap;
            while(j<len){
                if(i<n && j>=n){
                    swapifgreater(a,i,b,j-n);
                }
                else if(i>=n){
                    swapifgreater(b,i-n,b,j-n);
                }
                else{
                    swapifgreater(a,i,a,j);
                }
                i++;j++;
            }
            if(gap==1) break;
            gap = (gap+1)/2;
        }
    }
    static void swapifgreater(long a[], int i, long b[], int j){
        if(a[i]>b[j]){
            long t = a[i];
            a[i] = b[j];
            b[j] = t;
        }
    }
}