/*
conver infix expression to postfix expression
maintain ans string, stack
1. start scanning from left to right
2. if the scanned chharacter is an operand add it to the ans string
3. if the scanned chharacter is a open parenthesis
        add it to the stack
4. if the scanned character is a closing parenthesis, pop and add to the string until a opening parenthesis is encouuntered, discard the opening parenthesis
5. if scanned character is an operator
    pop and add to answer until the stack peek is <= in preceedence
    push the operator
6. at last pop and add until stack is empty
*/
class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if( (ch<='Z' && ch>='A') || (ch>='a' && ch<='z') || (ch<='9' && ch>='0')) sb.append(ch);
            else{
                if(ch=='(') stack.push(ch);
                else if(ch==')'){
                    while(stack.peek()!='(') sb.append(stack.pop());
                    stack.pop();
                }
                else{
                    while(!stack.isEmpty() && priority(ch)<=priority(stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        return new String(sb);
    }
    static int priority(char ch){
        switch(ch){
            case '^': return 5;
            case '*':
            case '/': return 4;
            case '+':
            case '-': return 3;
            default: return -1;
        }
    }
}