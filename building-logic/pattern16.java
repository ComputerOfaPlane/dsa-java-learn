/*

A 
B B
C C C
D D D D
E E E E E
F F F F F F

*/

public class Solution {
    public static void alphaRamp(int n) {
        // Write your code here

        for(char i='A'; i<n+65; i++){
            for(char j='A'; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}