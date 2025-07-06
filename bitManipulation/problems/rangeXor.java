/*
find the xor of all numbers in a given range

brute force:
just run a for loop

optimal:

observe from below:

>>> 1
1
>>> 1^2
3
>>> 1^2^3
0
>>> 1^2^3^4
4
>>> 1^2^3^4^5
1
>>> 1^2^3^4^5^6
7
>>> 1^2^3^4^5^6^7
0
>>> 1^2^3^4^5^6^7^8
8
>>> 1^2^3^4^5^6^7^8^9
1
>>> 1^2^3^4^5^6^7^8^9^10
11
>>> 1^2^3^4^5^6^7^8^9^10^11
0
>>> 1^2^3^4^5^6^7^8^9^10^11^12
12
>>> 1^2^3^4^5^6^7^8^9^10^11^12^13
1
>>> 1^2^3^4^5^6^7^8^9^10^11^12^13^14
15

we can notice

for xor rangle 1 -> n

if n%4 == 1 ans = 1
n%4 == 2 ans = n+1
n%4 == 3 ans = 0
n%4 == 0 ans = n

xor in range is

xor(l-1)^xor(r)
*/

class Solution {
    public static int findXOR(int l, int r) {
        return xor(l-1)^xor(r);
    }
    static int xor(int i){
        switch(i%4){
            case 1: return 1;
            case 2: return i+1;
            case 3: return 0;
            case 0: return i;
        }
        return 0;
    }
}