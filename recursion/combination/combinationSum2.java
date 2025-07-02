/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

approach: here we have to find unique collections of numbers so that we obtain the target
1. we sort the array
2. we skip the elements that have previously occured and may not result in a different tree
3. pick the element
4. then remove
basically pruning the recursion tree with different things
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0,candidates.length,candidates,new ArrayList<>(), ans,target);
        return ans;
    }
static void combination(int index, int n, int arr[], List<Integer> list, List<List<Integer>> ans, int sum)
    {
        System.out.println(list + " " + index);
        // if(index==n){
            // System.out.println(list);
            if(sum==0) {ans.add(new ArrayList<>(list));
            return;}
        // }
        int prev = Integer.MIN_VALUE;
        for(int i=index; i<n; i++){
            if(arr[i]>sum) break;
            if(prev!=arr[i]){
                prev = arr[i];
                list.add(arr[i]);
                combination(i+1,n,arr,list,ans,sum-arr[i]);
                list.remove(list.size()-1);
            }
        }
        
    }
}