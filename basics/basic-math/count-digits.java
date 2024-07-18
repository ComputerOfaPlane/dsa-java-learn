import java.util.Scanner;

class count {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        // Time Complexity = O(1)
        // Space Complexity = O(1)
        int numOfDigits = (int) (Math.log10(n) +1);

        System.out.println("number of digits = "+numOfDigits);
    }

    static int numberOfDigits(int n){

        // Time Complexity = O(log10 n) constantly div by 10
        // Space Complexity = O(1)

        int c=0;
        while(n>0){
            c++;
            n/=10;
        }
        return c;
    }
    static int evenlyDivides(int N){ // https://www.geeksforgeeks.org/problems/count-digits5716/1
        int temp=N;
        int c=0;
        while(temp>0){
            if(temp%10!=0 && N%(temp%10)==0)
                c++;
            temp/=10;
        }
        return c;
    }
    static int numberOfDigitsRec(int n){
        
        if(n<10){
            return 1;
        }
        else{
            return 1+numberOfDigitsRec(n/10);
        }
    }

}
