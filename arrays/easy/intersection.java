import java.util.* ;
import java.io.*; 

/*
intersection of two sorted arrays, result may contain duplicates

Brute Force:
for every element in array 1 traverse the array 2
keep a visited array for the smaller array and mark it as done if its accepted
time = O(n*m)
space = O(n)

Better:
2 pointer approach
start both from zero
if arr1 element is less than arr2 increase pointer 1 by 1
if arr2 element is less than increase the other pointer by 1 
else if equal  then increase both by one and store the element
time = O(N) n is size of smaller
space = O(N) to store result else O(1 for calculation)
*/
public class Solution
{
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        int size=0;

        while(i<n && j<m){
            size=list.size();
            if(arr1.get(i)<arr2.get(j)){
                i++;
            }
            else if(arr1.get(i)>arr2.get(j)){
                j++;
            }
            else{
                list.add(arr1.get(i));
                i++;j++;
            }

        }
        return list;
    }
}
