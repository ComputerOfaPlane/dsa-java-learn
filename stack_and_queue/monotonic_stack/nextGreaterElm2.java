/*
similarly like next greater element 1, we need to find the next greater elements of all the array elements but now

we are dealing with a circular array

to deal with it we can double the array or , we can use mod N

tc = O(4N)
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, len = 2*n;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=len-1; i>=0; i--){
            int elm = nums[i%n];
            while(!stack.isEmpty() && elm>=stack.peek()) stack.pop();
            if(i<n) nge[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(elm);
        }
        return nge;
    }
}