/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

idea:
we need to greedily place the smallest number at the beginning
if the number before is not small, we pop it

edge cases: nothing get poped? pop the last k characters
            everything is poped? return "0"
            handle leading zeros properly

*/
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k>0 && (stack.peek()-'0')>(ch-'0')){
                k-=1;
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(k-->0) stack.pop();
        if(stack.isEmpty()) return "0";
        while(!stack.isEmpty()) sb.append(stack.pop());
        sb = sb.reverse();
        int idx = -1;
        for(int i=0; i<sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch!='0'){
                idx = i;
                break;
            }
        }
        // System.out.println(sb+" "+idx);
        String ans = new String(sb);
        ans = idx!=-1?ans.substring(idx):"0";
        return ans.length()==0?"0":ans;
    }
}