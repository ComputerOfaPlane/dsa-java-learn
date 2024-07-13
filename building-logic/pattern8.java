/*

*****
 ***
  *

*/

public class Solution {
    public static void nStarTriangle(int n) {
        
        for(int i=n-1;i>=0;i--){

            for(int j=n-1;j>i;j--){
                System.out.print(" ");
            }

            for(int j=(i*2)+1;j>0;j--){
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}
/*
Aletrnate:

for (int i = 0; i < N; i++)
    {
        // For printing the spaces before stars in each row
        for (int j =0; j<i; j++)
        {
            System.out.print(" ");
        }
       
        // For printing the stars in each row
        for(int j=0;j< 2*N -(2*i +1);j++){
            
            System.out.print("*");
        }
        
        // For printing the spaces after the stars in each row
        for (int j =0; j<i; j++)
        {
            System.out.print(" ");
        }
       

        // As soon as the stars for each iteration are printed, we move to the
        // next row and give a line break otherwise all stars
        // would get printed in 1 line.
        System.out.println();
    }
*/