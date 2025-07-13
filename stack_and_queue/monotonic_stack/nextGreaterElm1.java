/*
given an array of distinct integers, you need to find the next greater element of a particular element to its right

for example:
in the array = [2,3,6,9,1,5,7,4]
nge of 4 = -1
nge of 9 = -1
nge of 2 = 3
nge of 3 = 6
nge of 7 = -1

and so on, find the first greater element and break;

optimal approach using monotonic stack?
what is monotonic stack: placing elements in a stack in a specific order

we try to place element in the stack such that all the elements are visible if we see the stack from top

                              |
(^_^) -> watching [ . , i, l, |]

everything is visible

so we traverse from right to left

if stack is empty we mark nge as -1

else if elm is less than stack peek we mark the peek as nge and push the element

or else

we keep popping until we find a greater element
*/
class Solution {
    public int[] nextGreaterElement(int[] nums2) {
        int n = nums1.length;
        int len = nums2.length;
        int nge[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=len-1; i>=0; i--){
            int elm = nums2[i];
            while(!stack.isEmpty() && elm>stack.peek()) stack.pop();
            nge[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(elm);
        }
        return nge;
    }
}