/*
Pascal's Triangle
there can be three cases that can be asked
1. find the element at a particular row and column
2. find the nth row of the triangle
3. find the entrire pascal's triangle

1. to find the element:
    > we can use nCr formula, if it is requried to find the element at row 6 and col 3 (1 based indexing),
    we can do (r-1)C(c-1), therefore 5C2 will give the element
    > to improve upon the above factorial calculation,
        we can simply do 5*4/2*1
        if 10C3 then (10*9*8) / (1*2*3)

2. to find the entire row:
> lets say we need to print row 6 (1 indexed), this row will have 6 elements
first element will always be one 
second elem = prev elm * (r-i)*(1/i)   // r==6, i=1
third elm = second elm * (6-2) / 2
then prev * 3/3
then prev * 2/4
then prev * 1/5
we have the entire row like this

3. to find the entire triangle find each row
*/


import java.util.*;
public class Solution {
    // get element
    public int elm(int r, int c){
        int ans = 1;
        for(int i=1; i<=c; i++){
            ans *= (r-i+1);
            ans = ans/i;
        }
        return ans;
    }

    // get row
    public List<Integer> getRow(int rowIndex) {
        return getrow(rowIndex+1);
    }
    static List<Integer> getrow(int r){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        long prev = 1;
        for(int i=1; i<r; i++){
            prev = prev*(r-i);
            prev = prev/i;
            list.add((int)prev);
        }
        return list;
    }

    // finds entire matrix by simulation
    public static int[][] pascalTriangle(int N) {
        int arr[][]=new int[N][];
        for(int i=0; i<N; i++){
            arr[i]=new int[i+1];
            arr[i][0]=1;
            for(int j=1; j<i; j++) arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            if(i>0) arr[i][i]=1;
        }
        return arr;
    }
}