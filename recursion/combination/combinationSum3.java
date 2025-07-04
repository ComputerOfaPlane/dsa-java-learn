/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

    Only numbers 1 through 9 are used.
    Each number is used at most once.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

we are given k and n, we need to form collections such that we pick k numbers, and their sum is 'n'
approach:
obs: first of all our range from where we will pick number will be [1,n-1]
then we make combinations from 1 to 9, by picking that number and recursing then backtracking
if the colleciton is of size k and n is 0 we add it to ans

*/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(1,k,new ArrayList<>(),ans,n);
        return ans;
    }
    static void generate(int index, int length, List<Integer> list, List<List<Integer>> ans, int target){
        if(list.size()==length && target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<=9; i++){
            list.add(i);
            generate(i+1, length, list, ans, target-i);
            list.remove(list.size()-1);
        }
    }
}