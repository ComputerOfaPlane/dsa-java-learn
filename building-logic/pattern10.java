/*

*
**
*** 
****
*****
******  
*****
****
***    
**
*

*/

public class Solution {
    public static void nStarTriangle(int n) {
        
        for(int i=0; i<2*n-1; i++){
            int limit = (i<n)?i:2*n-i-2;
            for(int j=0; j<=limit; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}