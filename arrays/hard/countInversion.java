/*
Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

brute better: traverse all the pairs in the array

optimal:

approach1: mergesort approach (divide and conquer)

mergesort logic is, we keep dividing the array, and then we keep merging the sorted arrays

alternated question: given two sorted arrays, count the number of relations where elements in first sorted array is greater than element in the second sorted array
eg,

7 8 9      1 8 8

7 is greater than 1
since 7 is greater and all elements to the left will also be greater
count += mid-left+1

move the pointer of second array

now, is 7 greater than 8, no!
move the pointer of first array

is 8 greater than 8? no!
move pointer of first array

is 9 greater than 8? yes! count increases, second array pointer moves

again is 9 greater than 8? yes! count increases, second array pointer moves

*/

import java.io.*;
import java.util.*;

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        return mergesort(arr,0,arr.length-1);
    }
    static int mergesort(int arr[], int low, int high){
        int count = 0;
        if(low<high){
            int mid = (high+low)/2;
            count += mergesort(arr, low, mid)+mergesort(arr,mid+1,high)+merge(arr,low,mid,high);
            return count;
        }
        else return count;
    }
    static int merge(int arr[], int left, int mid, int high){
        int i1 = left, i2 = mid+1;
        int temp[] = new int[high-left+1];
        int j = 0;
        int count = 0;
        while(i1<=mid && i2<=high){
            if(arr[i1]>arr[i2]){
                count += (mid-i1+1);
                temp[j] = arr[i2];
                i2++;
                j++;
            }
            else{
                temp[j] = arr[i1];
                i1++;
                j++;
            }
        }
        while(i1<=mid){
            temp[j] = arr[i1];
            i1++;
            j++;
        }
        while(i2<=high){
            temp[j] = arr[i2];
            i2++;
            j++;
        }
        for(int i=left; i<=high; i++) arr[i] = temp[i-left];
        return count;
    }
}