class HelloWorld {

    static void sumOfN(int i,int sum){ // sum of N numbers
        
        if(i<1){
            System.out.print("Sum" = sum);
            return;
        }
        sumOfN(i-1,sum+i); // calculating sum in the parameter

    }
    static int sumOfN(int n){ // sum of N numbers but 1 parameter
        
        if(n==1){
            return 1;
        }
        return n+sumOfN(n-1); // returning sum

    }
    static long sumOfSeries(long n) {
        
        if(n==0) return 0;
        return (n*n*n)+sumOfSeries(n-1);
    }
    static long factorial(long n) {
        
        if(n<=1) return 1;
        return n*sumOfSeries(n-1);
    }
    public static void main(String[] args) {

        sumOfN(5,0);

        System.out.println("\n");

        sumOfN(1,5);
        System.out.println("\n");

        sumOfN(5);
    }
}