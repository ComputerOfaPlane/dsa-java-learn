class Reverse{

    static int reverse(int n){

        // Time Complexity = O(log10 n) constantly div by 10
        // Space Complexity = O(1)

        int reverseNum = 0;
        while(n>0){
            int digit = n%10;
            reverseNum =(reverseNum*10)+digit;
            n/=10;
        }
        return reverseNum;
    }
}