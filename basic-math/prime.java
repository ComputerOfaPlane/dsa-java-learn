import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();

        int count=0;

        for(int i=1;i*i<=n;i++){
            if(n%i==0)
                count++;
        }

        System.out.println(count==1);
    }

}
// time = O(sprt(n))
// space = O(1)