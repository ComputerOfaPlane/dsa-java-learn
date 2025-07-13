/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

approach:

we can use stack as we would constantly need to know the topmost surviving asteroid

if stack is not empty and stack peek is positive and the current asteroid is negative, we check
    if the top asteroid size is less, we have to pop
    if it is equal, we destroy both 
    else we continue and destroy the current

*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        outer:for(int i:asteroids){
            while(!stack.isEmpty() && stack.peek()>0 && i<0){
                if(stack.peek()<-i) stack.pop();
                else if(stack.peek()==-i){
                    stack.pop();
                    continue outer;
                }
                else continue outer;
            }
            stack.push(i);
        }
        int n = stack.size();
        int ans[] = new int[n];
        for(int i=n-1; i>=0; i--) ans[i] = stack.pop();
        return ans;
    }
}