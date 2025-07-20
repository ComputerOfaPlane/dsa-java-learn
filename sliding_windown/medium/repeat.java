class Solution {
    public int characterReplacement(String s, int k) {
        int left=0, right = 0, n = s.length(), max = 1, f=0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            f = Math.max(f,map.get(ch));
            if((right-left+1)-f>k){
                char l = s.charAt(left);
                map.replace(l,map.get(l)-1);
                left += 1;
            }
            else max = Math.max(max,right-left+1);
            right+=1;
        }
        return max;
    }
}
/*
calculate the overflow everytime

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, n = s.length(), max = 0;
        int map[] = new int[26];
        while(right<n){
            char ch = s.charAt(right);
            map[ch-'A']+=1;
            int curr = get(map);
            while(curr>k){
                map[s.charAt(left)-'A']-=1;
                curr = get(map);
                left+=1;
            }
            max = Math.max(max,right-left+1);
            right+=1;
        }
        return max;
    }
    static int get(int map[]){
        int curr = 0, m = 0;
        for(int i:map){
            m = Math.max(m,i);
            curr += i;
        }
        curr-=m;
        return curr;
    }
}
*/