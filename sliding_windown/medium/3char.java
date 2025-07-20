/*
find the number of substrings containing all the three characters

we can map the three characters to the most recently ocured position

then we know the minimum window and add the substrings directly to answers
*/
class Solution {
    public int numberOfSubstrings(String s) {
        int right = 0, map[] = {-1,-1,-1}, n = s.length(), ans = 0;
        while(right<n){
            map[s.charAt(right)-'a'] = right;
            if(map[0]!=-1 && map[1]!=-1 && map[2]!=-1){
                int left = Math.min(map[0],Math.min(map[1],map[2]));
                ans += (left+1);
            }
            right+=1;
        }
        return ans;
    }
}
/*
if we want, we can also travel from the back
*/