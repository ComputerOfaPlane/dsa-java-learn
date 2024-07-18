class Solution {

    int count=0;

    void printGfg(int N) { // printing name N times
        
        /*
        Time Complexity = O(n) {fn is O(1) but is called n times}
        Space complexity = O(n) {basically stack space}
        */

        if(N==0) return;
        System.out.print("Aniket ");
        printGfg(N-1);
    }
    public void printNos(int N) // printing from 1 to N
    {
        if(count==N) return; // to avoid count we can have two parameters 

        System.out.print(++count+" ");
        printNos(N);
        
    }
    void printNosi(int N) { // printing from N to 1

        if(N==0) return;

        System.out.print(N+" ");
        printNos(N-1);
    }
}

// backtracking basic

class HelloWorld {
    static void printnums(int i,int n){ // printing 1 to N
        if(i<1){
            return;
        }
        printnums(i-1,n);
        System.out.print(i+" ");
    }
    static void printnumsi(int i,int n){ // printing N to 1
        if(i>n){
            return;
        }
        printnumsi(i+1,n);
        System.out.print(i+" ");
    }
    public static void main(String[] args) {
        printnums(5,5);
        System.out.println("\n");
        printnumsi(1,5);
    }
}