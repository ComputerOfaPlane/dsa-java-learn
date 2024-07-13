/*

   *
  ***
 *****
*******

*/

public class Solution {
    public static void nStarTriangle(int n) {
        
        
        for(int i=0;i<n;i++){

            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            /*
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            */
            for(int j=0;j<(i*2)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}