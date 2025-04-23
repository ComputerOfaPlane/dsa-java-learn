/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

my approach:

using concept of distinct characters,
we can replace each distinct character with a character id which is rank at which this distinct character was found

as in the example we can tranfor "egg" to "122"
and "add" can be transformed to "122"

now just compared the transformed string
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int distinct1[] = new int[256];
        int distinct2[] = new int[256];
        int d1 = 0, d2 = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            int curr1=-1, curr2=-1;
            if(distinct1[chs]==0){
                d1++;
                distinct1[chs] = d1;
                curr1=d1;
            }
            else curr1 = distinct1[chs];
            if(distinct2[cht]==0){
                d2++;
                distinct2[cht] = d2;
                curr2 = d2;
            }
            else curr2 = distinct2[cht];
            if(curr1!=curr2) return false;
        }
        return true;
    }
}