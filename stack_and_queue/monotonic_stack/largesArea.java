/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.



Input: matrix = [ ["1","0","1","0","0"],
                  ["1","0","1","1","1"],
                  ["1","1","1","1","1"],
                  ["1","0","0","1","0"] ]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.


we can solve this by using the concept of max area under a histogram

move the x axis of a histogram one by one till we reach the last row
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length, c = matrix[0].length, max = -1;
        int curr[] = new int[c];
        int histogram[] = new int[c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) curr[j]+=(matrix[i][j]-'0');
            for(int j=0; j<c; j++){
                if(matrix[i][j]=='0') curr[j] = 0;
                histogram[j] = curr[j];
            } 
            // System.out.println(Arrays.toString(histogram));
            max = Math.max(max,largestRectangleArea(histogram));
        }
        return max;
    }
// my own code https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/1692983258/
    static public int largestRectangleArea(int[] heights) {
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
