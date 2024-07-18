/*

1
2 3
4 5 6

*/
public class Solution {
    public static void nNumberTriangle(int n) {
        
        int count=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }
}