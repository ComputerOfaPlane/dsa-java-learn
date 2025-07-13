/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10

we can observe we need the previous smaller element index and next smaller element index to find out the width
then we can multiply with the height

we can further optimise this by calculating the pse and nse in runtime
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = -1;
        Stack<Integer> stack = new Stack<>();
        int pse[] = new int[n];
        for(int i=0; i<n; i++){
            int elm = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()]>=elm){
                int nse = i;
                max = Math.max(max,(nse-pse[stack.peek()]-1)*heights[stack.peek()]);
                // System.out.println(max);
                stack.pop();
            }
            pse[i] = (stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        // System.out.println(stack);
        while(!stack.isEmpty()){
            max = Math.max(max,(n-pse[stack.peek()]-1)*heights[stack.peek()]);
            stack.pop();
        }
        return max;
    }
}
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = nse(heights,n);
        int pse[] = pse(heights,n);
        int max = -1;
        for(int i=0; i<n; i++) max = Math.max(max,(nse[i]-pse[i]-1)*heights[i]);
        return max;
    }
    static int[] nse(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; --i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>=elm) stack.pop();
            ans[i] = (stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] pse(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; ++i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>elm) stack.pop();
            ans[i] = (stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
*/