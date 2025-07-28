class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=g.length-1, j=s.length-1, count = 0;
        while(i>=0 && j>=0){
            if(g[i]<=s[j]){
                i-=1;
                j-=1;
                count+=1;
            }else i-=1;
        }
        return count;
    }
}