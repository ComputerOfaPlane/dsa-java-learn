/*
largest substring with k distinct characters
*/
class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int left = 0, right = 0, n = s.length(), len = -1;
        Map<Character, Integer> map = new HashMap<>();
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k){
                char l = s.charAt(left);
                map.replace(l,map.get(l)-1);
                if(map.get(l)==0) map.remove(l);
                left+=1;
            }
            else if(map.size()==k) len = Math.max(len,right-left+1);
            right += 1;
        }
        return len;
    }
}