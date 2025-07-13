/*
check if a string have balanced parenthesis or not
*/
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            // System.out.println((int)ch);
            if(stack.isEmpty()) stack.push((int)ch);
            else{
                int peek = stack.peek();
                if(peek==ch-1 || peek==ch-2) stack.pop();
                else stack.push((int)ch);
            }
        }
        // System.out.println(stack);
        return stack.isEmpty();
    }
}