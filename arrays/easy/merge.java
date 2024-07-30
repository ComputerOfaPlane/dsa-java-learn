import java.util.*;

/*
To merge two sorted array such that the result is sorted and doesnt contain any duplicate  elements

brute force:
make an ordered set 
traverse the arrays and keep pushing the elements in the set from both arrays
the set will be the answer
n, m is the size of array; z is the size of set
time = O(nlogz) + O(mlogz)
space = O(z) or O(n+m)

better:
2 pointer approach
both pointer starts from zero
if element of arr1<= arr2 check the last inserted element then add it
else check the last add elm of arr2
if anything is left add them
time = O(n) n is size of larger array
space = O(n) // required as result else O(1)
*/

public class Solution {

    public static List< Integer > sortedArray(int []a, int []b) {
        
        List<Integer> list = new ArrayList<>();

        int i=0,j=0;
        int al = a.length;
        int bl = b.length;
        int size=0;

        while(i<al && j<bl){
            size=list.size();
            if(a[i]<=b[j]){

                if(size==0 || list.get(size-1)!=a[i]){
                    list.add(a[i]);
                }
                i++;
            }
            else{
                if(size==0 || list.get(size-1)!=b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }

        while(i<al){
            size=list.size();
            if(size==0 || list.get(size-1)!=a[i]){
                list.add(a[i]);
            }
            i++;
        }
        while(j<bl){
            size=list.size();
            if(size==0 || list.get(size-1)!=b[j]){
                list.add(b[j]);
            }
            j++;
        }
        return list;
    }
}