/*

A
A B
A B C
A B C D
A B C D E
A B C D E F

*/

public class Solution {
    public static void nLetterTriangle(int n) {
        
        
        for(char i='A'; i<n+65; i++){
            for(char j='A'; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
