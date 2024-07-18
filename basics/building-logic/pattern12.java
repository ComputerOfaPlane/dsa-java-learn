/*

1          1
12        21
12       321
1234    4321
12345  54321
123456654321

*/

public class Solution {
    public static void numberCrown(int n) {
        
        int spaces = 2*n-2;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((j+1)+" ");
            }
            for(int j=0;j<spaces;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=0;j--){
                System.out.print((j+1)+" ");
            }
            System.out.println();
            spaces-=2;
        }
    }
}