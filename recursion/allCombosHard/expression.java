/*
Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.

Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.

Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.


approach: we can do a 4^n approrach, form expression and evalutate at the end, this will take very long

optimal: track previous, calculate answer in runtime
 
*/
class Solution {
    public List<String> addOperators(String num, int target) {
        int n = num.length();
        List<String> ans = new ArrayList<>();
        if(num.length()==1 && Integer.parseInt(num)==target){
            ans.add(num);
            return ans;
        }
        fill(0,"",num,0L,0L,(long)target,ans);
        return ans;
    }
    static void fill(int index, String s, String num, long curr, long prev, long target, List<String> ans){
        if(index==num.length()){
            if(curr==target) ans.add(s);
            return;
        }
        long number = 0L;
        for(int i=index; i<num.length(); i++){
            if(i!=index && num.charAt(index)=='0') break;
            String temp = num.substring(index,i+1);
            number = Long.parseLong(temp);
            if(index==0){
                fill(i+1,temp,num,number,number,target,ans);
            }
            else{
                fill(i+1,s+'+'+temp,num,curr+number,number,target,ans);
                fill(i+1,s+'-'+temp,num,curr-number,-number,target,ans);
                fill(i+1,s+'*'+temp,num,curr-prev + prev*number,prev*number,target,ans);
            }
        }
    }
}
/*
sub optimal


import java.util.StringTokenizer;
class Solution {
    public List<String> addOperators(String num, int target) {
        int n = num.length();
        List<String> ans = new ArrayList<>();
        if(num.length()==1 && Integer.parseInt(num)==target){
            ans.add(num);
            return ans;
        }
        fill(1, ""+num.charAt(0), num, target, ans);
        return ans;
    }
    static void fill(int index, String s, String num, int target, List<String> ans){
        if(index==num.length()){
            if(compute(s)==(long)target) ans.add(s);
            return;
        }
        boolean allow = true;
        String temp = s + num.charAt(index);
        int i = temp.length()-1;
        while(i>=0 && isnumber(temp.charAt(i))) i--;
        temp = temp.substring(i+1);
        if(temp.length()>1 && temp.charAt(0)=='0') allow = false;
        
        if(allow) fill(index+1,s+num.charAt(index),num, target, ans);
        fill(index+1,s+'*'+num.charAt(index),num, target, ans);
        fill(index+1,s+'+'+num.charAt(index),num, target, ans);
        fill(index+1,s+'-'+num.charAt(index),num, target, ans);
    }
    static long compute(String s){
        // convert to postfix
        List<String> postfix = toPostFix(s);
        // evaluate postfix
        return evaluate(postfix);
    }
    static long evaluate(List<String> s){
        Stack<Long> stack = new Stack<>();
        int n = s.size();
        for(int i=0; i<n; i++){
            String ch = s.get(i);
            if(isnumber(ch.charAt(0)) || ch.length()>1) stack.push(Long.parseLong(ch));
            else{
                long res = 0L, a = stack.pop(), b = stack.pop();
                switch(ch){
                    case "*":
                        res = a*b;
                        break;
                    case "+":
                        res = a+b;
                        break;
                    case "-":
                        res = b-a;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
    static List<String> toPostFix(String s){
        s = s+')';
        StringTokenizer st = new StringTokenizer(s,"*+-)",true);
        Stack<Character> stack = new Stack<>();
        List<String> sb = new ArrayList<>();
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.length()>1 || isnumber(token.charAt(0))) sb.add(""+Long.parseLong(token));
            else{
                if(token.equals(")")) while(!stack.isEmpty()) sb.add(stack.pop()+"");
                else if(stack.isEmpty()) stack.push(token.charAt(0));
                else{
                    if(preceedence(token.charAt(0))>preceedence(stack.peek())) stack.push(token.charAt(0));
                    else{
                        while(!stack.isEmpty() && preceedence(token.charAt(0))<=preceedence(stack.peek()))
                            sb.add(stack.pop()+"");
                        stack.push(token.charAt(0));
                    }
                }
            }
        }
        return sb;
    }
    static boolean isnumber(char s){
        return s>='0' && s<='9';
    }
    static int preceedence(char op){
        switch(op){
            case '*': return 3;
            default: return 1;
        }
    }
}
*/