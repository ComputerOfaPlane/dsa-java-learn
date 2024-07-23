import java.util.* ;
import java.io.*; 

public class Solution {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(7);
        arr.add(6);
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(0);

        List<Integer> res = new ArrayList<>();

        res = quickSort(arr);

        System.out.println(res);

    }
    public static List<Integer> quickSort(List<Integer> arr){
        quicksorti(arr, 0, arr.size()-1);
        return arr;
    }
    static void quicksorti(List<Integer> arr, int low, int high){
        if(low<high){
            int partitiion = partitionFn(arr,low,high);
            quicksorti(arr, low, partitiion-1);
            quicksorti(arr, partitiion+1, high);
        }
    }
    static int partitionFn(List<Integer> arr, int low, int high){
        int pivot = arr.get(low);
        int i=low;
        int j=high;

        while(i<j){


            while(arr.get(i)<=pivot && i<high){
                i+=1;
            }
            while(arr.get(j)>pivot && j>low){
                j-=1;
            }

            if(i<j){
                int t=arr.get(i);
                arr.set(arr.get(j),i);
                arr.set(t,j);
            }
        }
        int t=arr.get(low);
        arr.set(arr.get(j),low);
        arr.set(t,j);
        return j;
    }
}