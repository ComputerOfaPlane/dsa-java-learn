/*
just like a keypad phone, to type we need to press numbers to get a string,
so we are given a string of numbers between [2,9]
we need to return the combinations of string that can be generate from the numbers

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

approach:
1. store the mapping of numbers to digits
2. obs: the length of a particular combination will be equal to the length of the input string
3. now for each number scanned, add a mapped character in a nested loop and recurse by picking that character
    then recurse by picking the next character,
    note: we are moving to the next index too soo same number mapped characters are not repeated
*/

class Solution {
    static String map[] = {"","", "abc", "def", "ghi","jkl","mno","pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> ans = new ArrayList<>();
        if(len==0) return ans;
        generate(0,digits,"",ans);
        return ans;
    }
    static void generate(int index, String digits, String temp, List<String> ans){
        if(digits.length()==temp.length()){
            ans.add(temp);
            return;
        }
        for(int i=index; i<digits.length(); i++){
            char ch = digits.charAt(i);
            int mapi = ch-'0';
            String letters = map[mapi];
            for(int j=0; j<letters.length(); j++){
                generate(i+1,digits,temp+letters.charAt(j),ans);
            }
        }
    }
}