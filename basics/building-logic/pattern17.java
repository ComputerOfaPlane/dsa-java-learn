/*

    A
  A B A
A B C B A

*/
public class Solution {
    public static void alphaHill(int n) {
        
        for(int i=0; i<n;i++){

            for(int j=0;j<n-i-1;j++){
                System.out.print("  ");
            }
            char x='A';
            for(int j=0; j<2*i+1;j++){
                System.out.print(x+" ");
                x=(j>=i)?(char)(x-1):(char)(x+1);
            }
            System.out.println();

        }
        
    }
}