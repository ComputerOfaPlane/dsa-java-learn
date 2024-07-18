/*

n=3
* * * * * * 
* *     * * 
*         * 
*         * 
* *     * * 
* * * * * * 

*/
public class Solution {
    public static void symmetry(int n) {
        
        
        for(int i=1; i<=n; i++){
            for(int j=n; j>=i;j--){
                System.out.print("* ");
            }
            for(int j=1; j<=2*i-2; j++){
                System.out.print("  ");
            }
            for(int j=n; j>=i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--){
            for(int j=n; j>=i;j--){
                System.out.print("* ");
            }
            for(int j=1; j<=2*i-2; j++){
                System.out.print("  ");
            }
            for(int j=n; j>=i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}