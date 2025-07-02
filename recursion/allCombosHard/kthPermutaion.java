/*
find the kth permutation lexographically

find permutations, stop at kth one
*/
class Solution {
    static int count = 0;
    public String getPermutation(int n, int k) {
        char a[] = new char[n];
        boolean visited[] = new boolean[n];
        for(int i=1; i<=n; i++) a[i-1]=(char)('0'+i);
        count = k;
        get(a,visited,"");
        return new String(a);
    }
    static boolean get(char a[], boolean visited[], String s){
        if(s.length()==a.length){
            count--;
            if(count==0){
                for(int i=0; i<a.length; i++) a[i] = s.charAt(i);
                return true;
            }
            return false;
        }
        for(int i=0; i<a.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(get(a,visited,s+a[i])) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}