import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int numOdigi = (int)(Math.log10(n)+1);
        int tmp = n;
        int sum=0;


        // time = O(10)
        while(tmp>0){
            sum+=Math.pow(tmp%10, numOdigi);
            tmp/=10;
        }
        
        System.out.println((n==sum));
    }
}
