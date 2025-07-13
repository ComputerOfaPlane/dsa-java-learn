/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Input: height = [4,2,0,3,2,5]
Output: 9

intuition: to find the trapped rain water we need to know the left and right boundaries, using these bondaries we can conclude the level at which the water can stay

we can find the left and right boundaries by

1. using left and right prefix and suffix max arrays respectively

2. optimal: two pointers

we need to find the minimum of left and right boundaries to conclude the max level at which the water will stay

so we keep leftmax and rightmax

we keep two pointers one at left extreme, other at right extreme

we traverse until left!=right

if left< right
    we have to check if left is less than leftmax, that would mean water 
    update leftmax, increment left
else
    right is less than, so now we check if right is less than rightmax
    update rightmax, decrement right
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0, leftmax = 0, rightmax = 0, left = 0, right = n-1;
        while(left!=right){
            int leftnum = height[left], rightnum = height[right];
            if(leftnum<rightnum){
                if(leftmax>leftnum){
                    ans += leftmax-leftnum;
                }
                leftmax = Math.max(leftnum,leftmax);
                left++;
            }
            else{
                if(rightmax>rightnum){
                    ans += rightmax-rightnum;
                }
                rightmax = Math.max(rightmax,rightnum);
                right--;
            }
        }
        return ans;
        /*int rtl[] = new int[n];
        rtl[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) rtl[i] = Math.max(height[i],rtl[i+1]);
        int curr = height[0], traped = 0;
        for(int i=1; i<n; i++){
            curr = Math.max(curr,height[i]);
            int min = Math.min(curr,rtl[i]);
            traped += min - height[i];
        }
        return traped;*/
    }
}