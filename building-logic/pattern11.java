/*

1
0 1
1 0 1
0 1 0 1
1 0 1 0 1

*/
public class Solution {
    public static void nBinaryTriangle(int n) {
        
        for(int i=0; i<n; i++){
            for(int j=0;j<=i;j++){
                System.out.print(((i+j)%2==0)?"1 ":"0 ");
            }
            System.out.println();
        }

    }
}