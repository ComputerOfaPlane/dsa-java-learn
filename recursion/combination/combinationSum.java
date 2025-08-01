/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the

of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

approach:

in subsequence for a particular index we were trying to either pick that element in that index, or not pick that element in that index
then move forward

here, as the same element can be picked multiple times
we make slight changes
1. pick not pick logic remains same, but when we pick, we do not move forward in the index
2. before picking we check if picking it may lead to a result or not

not pick logic remains same
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        combination(0,n,candidates,new ArrayList<>(), ans,target);
        return ans;
    }
    static void combination(int index, int length, int arr[], List<Integer> list, List<List<Integer>> ans, int sum){
        if(index==length){
            if(sum==0) ans.add(new ArrayList<>(list));
            return;
        }
        if(arr[index]<=sum){
            list.add(arr[index]);
            combination(index, length, arr, list, ans, sum-arr[index] );
            list.remove(list.size()-1);
        }
        combination(index+1, length, arr, list, ans, sum);
    }
}