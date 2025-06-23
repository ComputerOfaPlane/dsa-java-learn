/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

similar approach:
1. generate all subsequence
2. take operation: add '('
   no take operation: add ')'
3. one subsequence is constructed, validate the sequence

*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        generate(0,2*n,list,s);
        return list;
    }
    static void generate(int index, int n, List<String> list, String s){
        if(index==n){
            // System.out.println(s);
            if(valid(s)) list.add(s);
            return;
        }
        generate(index+1, n, list, s+'(');
        generate(index+1, n, list, s+')');
    }
    static boolean valid(String s){
        int len = s.length();
        if(len==0) return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()) stack.push(ch);
            else{
                if(stack.peek()=='(' && ch==')') stack.pop();
                else stack.push(ch);
            }
        }
        return stack.size()==0;
    }
}