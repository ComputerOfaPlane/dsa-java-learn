/*
similarly like next greater elements we can find previous smaller elements
*/
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        for(int i=0; i<n; i++){
            int elm = A.get(i);
            while(!stack.isEmpty() && elm<=stack.peek()) stack.pop();
            list.add(stack.isEmpty()?-1:stack.peek());
            stack.push(elm);
        }
        return list;
    }
}
