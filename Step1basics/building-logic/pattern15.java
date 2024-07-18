/*

A B C D E F
A B C D E 
A B C D
A B C
A B
A

*/

public class Solution {
    public static void nLetterTriangle(int n) {
        // Write your code here

        for(int i=0; i<n; i++){
            char p='A';
            for(int j=n; j>i; j--){
                System.out.print(p++ +" ");
            }
            System.out.println();
        }
    }
}
