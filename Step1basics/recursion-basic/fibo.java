class FiboSeries {
    static int fib(int n) {
        
        // time = O(2^n) exponential {each time 2 recursion call branch}
        // space= O(n) heinght of recursion tree
        
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
    static int fibo(int n) {
        if(n<=1) return n;
        int last = fibo(n-1);
        int sclast = fibo(n-2);
        return last+sclast;
    }
    static int fiboloop(int n){ 
        // time = O(n)
        // space = O(1)
        if(n<=1){
            return n;
        }
        int i=0;
        int j=1;
        int sum=0;
        for(int l=2;l<=n;l++){
            sum=i+j;
            i=j;
            j=sum;
        }
        return sum;
    }
    public static void main(String args[]){
        
        System.out.println(fiboloop(7));
        System.out.println(fib(7));
        System.out.println(fibo(7));
    }
}