/*
given an array of integers containing prices of a stock on each day
[7,1,5,3,6,4]
to find the max profit that can be earned

brute:
run a nested loop
for i->n // buy
    for j=i -> n // sell
        if(price of inner is greater than price of outer) max = profit(j-i),max
time  = O(n^2)
space = O(1)

better:
maintain two variables
one for the minimum buy price
other for the max profit
traverse array and try to find the profit
store max profit
store min buy price
time = O(n)
space = O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int i:prices){
            int profit=i-min;
            max=Math.max(profit,max);
            min=Math.min(min,i);
        }
        return max;
    }
}