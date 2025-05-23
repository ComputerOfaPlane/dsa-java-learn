/*
we are given two sorted arrays, we need to find the median of the combined sorted array

brute force:

do a normal merge, merge both the arrays to a third array
then return the medium

better: reducing space complexity:
instead of merging the array into a third array, use pointers to find the elements that will be needed to find mediam

optimal:

read takeuforward blog, to much to write
https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
*/



import java.util.*;

public class tUf {
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + median(a, b));
    }
}



class Better {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1=0, i2=0, j1 = nums1.length, j2 = nums2.length;
        int len = j1+j2;
        int k = 0, elm1 = -1, elm2 = -1, idx1 = len/2 - 1, idx2 = len/2;
        int merged[] = new int[len];
        while(i1<j1 && i2<j2){
            if(nums1[i1]<=nums2[i2]){
                if(k==idx1) elm1 = nums1[i1];
                if(k==idx2) elm2 = nums1[i1];
                i1++;
                k++;
            }
            else{
                if(k==idx1) elm1 = nums2[i2];
                if(k==idx2) elm2 = nums2[i2];
                i2++;
                k++;
            }
        }
        while(i1<j1){
            if(k==idx1) elm1 = nums1[i1];
            if(k==idx2) elm2 = nums1[i1];
            i1++;
            k++;
        }
        while(i2<j2){
            if(k==idx1) elm1 = nums2[i2];
            if(k==idx2) elm2 = nums2[i2];
            i2++;
            k++;
        }
        return len%2==1?elm2+0.0:(elm1+elm2)/2.0;
    }
}