/*
we are trying to reverse a stack
we need to remember the stack elements somehow, which is achieved through backtracking

then once the stack is empty and we remember the elements,

then we need to push the elements such that the they are pushed at the bottom

*/
class Solution {
    static void reverse(Stack<Integer> s) {
        // add your code here
        if(!s.isEmpty()){
            int x = s.pop();
            reverse(s);
            helper(s,x);
        }
    }
    static void helper(Stack<Integer> s, int x){
        if(s.isEmpty()) s.push(x);
        else{
            int num = s.pop();
            helper(s,x);
            s.push(num);
        }
    }
}

