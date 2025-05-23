/*
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

    Each student receives atleast one book.
    Each student is assigned a contiguous sequence of books.
    No book is assigned to more than one student.

The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

here we need to allocated books according to the following conditions

lets take an example
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.


what we can do is lets say we allocate 50 pages to each student, then we count 

first student gets 12+34, then we cant allocate anymore books to any students so we need to increase the pages we can give to students


lets take it to 90

we can here finally allocate books to all students but we would need three students to do so which is not allowed


now lets do even higher lets say 250, now we are allocating all books to one student which is also not allowed

so our range of answers will be within [max pages, sum of array]

within this range we need to find the first occurence where allocation is valid and that will be our answer

if we have less students we move left, if we need more students we move right

*/
class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length, left = -1, right=0;
        if(n<k) return -1;
        for(int i:arr){
            left = Math.max(left,i);
            right+=i;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            int studentcount = student(arr,n,mid);
            if(studentcount<=k) right=mid-1;
            else left = mid+1;
        }
        return left;
    }
    static int student(int pages[], int n, int pagecount){
        int curr = 0, t = 0;
        for(int i=0; i<n; i++){
            if(curr+pages[i]<=pagecount) curr+=pages[i];
            else{
                t++;
                curr = pages[i];
            }
        }
        if(curr>0) t++;
        return t;
    }
}