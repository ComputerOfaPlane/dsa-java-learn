/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

how i solved it:

make two maps, frequency of string t, 
smap for string s which stores, character and the indices of occurences
tc = O(n+m)
sc = O(26+26)

striver gave a more better code than mine, i did not understand it or probobly find my solution better 
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Queue<Integer>> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        int sn = s.length(), tn = t.length(), right = 0, min = Integer.MAX_VALUE;
        String ans = "";
        for(int i=0; i<tn; i++) tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        while(right<sn){
            char ch = s.charAt(right);
            if(tmap.containsKey(ch)){
                if(smap.containsKey(ch)){
                    smap.get(ch).add(right);
                    int req = tmap.get(ch);
                    if(req<smap.get(ch).size()) smap.get(ch).poll();
                }else{
                    Queue<Integer> q = new LinkedList<>();
                    q.add(right);
                    smap.put(ch,q);
                }
            }
            int idx = is(smap,tmap);
            if(idx!=-1){
                int len = right-idx+1;
                if(len<min){
                    min = len;
                    ans = s.substring(idx,right+1);
                }
                // smap = new HashMap<>();
            }
            right += 1;
        }
        return ans;
    }
    static int is(Map<Character, Queue<Integer>> smap, Map<Character, Integer> tmap){
        int left = Integer.MAX_VALUE;
        for(char key:tmap.keySet()){
            if(!smap.containsKey(key)) return -1;
            if(smap.get(key).size()!=tmap.get(key)) return -1;
            left = Math.min(left,smap.get(key).peek());
        }
        return left;
    }
}