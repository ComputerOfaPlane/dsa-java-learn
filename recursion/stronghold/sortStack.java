/*
sort a stack

same as reverse just we need not push at the bottom but till a point where we can
*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(!s.isEmpty()){
            int x = s.pop();
            sort(s);
            helper(s,x);
        }
        return s;
    }
    static void helper(Stack<Integer> s, int x){
        if(s.isEmpty() || s.peek()<x) s.push(x);
        else{
            int num = s.pop();
            helper(s,x);
            s.push(num);
        }
    }
}