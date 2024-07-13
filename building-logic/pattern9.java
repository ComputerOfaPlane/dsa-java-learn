/*

    *    
   ***   
  *****  
 ******* 
*********
*********
 ******* 
  *****  
   ***   
    *   

*/
public class Solution {
    public static void nStarDiamond(int n) {
        
        
        for(int i=0;i<n;i++){

            for(int j=n-i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<(i*2)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++)
        {
            for (int j =0; j<i; j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j< 2*N -(2*i +1);j++){
                
                System.out.print("*");
            }
            System.out.println();
        }

    }
}