import java.util.* ;
import java.io.*; 
/*
given [0,1,1,0,1,1,1,1,0,0,1,0,1,0,1,1,1,0,1,1,1]

approach:

take 2 variables
one stores the max consecutive ones
other stores the currentconsecutive ones status
traverse the array if 1 is found then increase consecutive by1
else set the max if needed and set consecutive ones status to zero
return the max between max and consecutive
time = O(N)
space = O(1)

*/
public class Solution {

    public static int consecutiveOnes(int n, int[] arr) {
        
        int consequtive = 0;
        int max=0;

        for(int i=0;i<n; i++){
            int num = arr[i];

            if(num==1)
                consequtive++;
            else{
                if(consequtive>max) max = consequtive;
                consequtive=0;
            }
        }
        return (max>consequtive)?max:consequtive;
    }
}