/*

*         *
* *     * *
* * * * * *
* *     * *
*         *

for(int i=1; i<=n; i++){
    for(int j=1; j<=i;j++){
        System.out.print("* ");
    }
    for(int j=2*i-2; j>=1; j--){
        System.out.print("  ");
    }
    for(int j=1; j<=i;j++){
        System.out.print("* ");
    }
    System.out.println();
}
for(int i=n-1; i>=1; i--){
    for(int j=1; j<=i;j++){
        System.out.print("* ");
    }
    for(int j=2*i-2; j>=1; j--){
        System.out.print("  ");
    }
    for(int j=1; j<=i;j++){
        System.out.print("* ");
    }
    System.out.println();
}

*/

public class Solution {
    public static void symmetry(int n) {
        int spaces = 2*n-2;
        for(int i=1; i<=2*n-1; i++){
            int stars = (i>n)?2*n-i:i;
            for(int j=1; j<=stars;j++){
                System.out.print("* ");
            }
            for(int j=1; j<=spaces; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=stars;j++){
                System.out.print("* ");
            }
            System.out.println();
            spaces = (i<n)?spaces-2:spaces+2;
        }
    }
}