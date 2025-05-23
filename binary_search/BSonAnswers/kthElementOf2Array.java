/*
using the same concept of symmetry as median of two arrays,

here left will be max(0,k-n2)
                    because lets say k is very big and if we take entire n2, we would still need to take some elements from n1
     right will be min(n1,k)
                    there will be no point in taking entire array n1 if we need just k elements to the left of symmetry

kth element will be max of l1,l2

*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        if(n2<n1) return kthElement(b,a,k);
        int n = n1+n2;
        int left = Math.max(0,k-n2), right = Math.min(n1,k);
        while(left<=right){
            int mid = (left+right)/2;
            int l1 = mid-1<0?Integer.MIN_VALUE:a[mid-1];
            int l2 = k-mid-1<0?Integer.MIN_VALUE:b[k-mid-1];
            int r1 = mid<n1?a[mid]:Integer.MAX_VALUE;
            int r2 = k-mid<n2?b[k-mid]:Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            else{
                if(l1>r2) right = mid-1;
                else left = mid+1;
            }
        }
        return 0;
    }
}