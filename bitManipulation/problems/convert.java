/*
conver a number A to B, and return the number of bits needed to toggle in a to make it b

right shift both a and b until both are equal and compare the right most bit if they are unequal +=1 and toggle
*/
class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int i = 0;
        while(start!=goal){
            if( ((start>>i)&1) != ((goal>>i)&1) ){ // instead of shifting i times, i just could have just shifted 1 times * i
                count+=1;
                start = (1<<i)^start;
            }
            i+=1;
        }
        return count;
    }
}