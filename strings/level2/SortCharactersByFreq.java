/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

my approach:

create a map, where you can map frequency to the ascii character
sort the map in descending order
now construct the new string

*/
class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int map[][] = new int[128][2];
        for(int i=0; i<128; i++) map[i][1]=i;
        for(int i=0; i<n; i++) map[s.charAt(i)][0]++;
        Arrays.sort(map,(row1,row2)->-Integer.compare(row1[0],row2[0]));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<128; i++){
            int freq = map[i][0];
            if(freq==0) break;
            char ch = (char) map[i][1];
            for(int j=1; j<=freq; j++) sb.append(ch);
        }
        return new String(sb);
    }
}