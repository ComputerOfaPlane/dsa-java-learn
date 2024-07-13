/*
/*
C
C B 
C B A
public class Solution {
    public static void alphaTriangle(int n) {
        
        for(int i=0; i<n; i++){
            char star= (char) (n+64);
            for(int j=0; j<=i; j++){
                System.out.print(star-- +" ");
            }
            System.out.println();
        }
    }
}
*/
/*

F
E F
D E F
C D E F
B C D E F
A B C D E F

*/

class pattern18 {
    public static void main(String[] args) {
        int n=5; // can be anything

        for (int i=1; i<=n;i++ ) {
            char x=(char)(65+n-i);
            for (int j=1; j<=i; j++) {
                System.out.print(x);
                x+=1;
            }
            System.out.println();
        }
    }
}

/*
alt:

for(int i=0;i<N;i++){
          
          // Inner loop for printing the alphabets from
          // A + N -1 -i (i is row no.) to A + N -1 ( E in this case).
          for(char ch =(char)(int)('A'+N-1-i);ch<=(char)(int)('A'+N-1);ch++){
              
              System.out.print(ch + " ");
          }
          
          // As soon as the letters for each iteration are printed, we move to the
          // next row and give a line break otherwise all letters
          // would get printed in 1 line.
          System.out.println();
      }

*/