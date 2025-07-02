/*
Given an integer array nums that may contain duplicates, return all possible

(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

use the pruning technique from combination sums 2

approach:

1. sort the array
2. pick the element if it leads to a unique recursion tree
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,nums,new ArrayList<>(), ans);
        return ans;
    }
    static void generate(int index, int arr[], List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        int prev = Integer.MIN_VALUE;
        for(int i=index; i<arr.length; i++){
            if(prev!=arr[i]){
                prev =arr[i];
                list.add(arr[i]);
                generate(i+1,arr,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}