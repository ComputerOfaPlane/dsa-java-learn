/*
Given a string s, partition s such that every substring of the partition is a pallindrome

Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

understand it as a subproblem:

approach:
let s = "aabb"

partition a | abb
a is pallindrome so recurse with new string as abb

then partition like aa | bb
add aa
then recurse b | b
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(s, new ArrayList<>(), ans);
        return ans;
    }
    static void generate(String s, List<String> list, List<List<String>> ans){
        if(s.length()==0){
            // System.out.println(list);
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int partition=0; partition<s.length(); partition++){
            String x = s.substring(0,partition+1);
            if(pallindrome(x)){
                list.add(x);
                generate(s.substring(partition+1),list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    static boolean pallindrome(String s){
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}