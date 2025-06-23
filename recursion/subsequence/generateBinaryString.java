/*
generate binary strings which do not have consecutive 1s

approach: generate all subsequences
          if any occurence of consecutive 1 occur, break that recursion branch

          for take add '1' to string
          for not take add '0' to the string
*/
class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        int index = 0; String s = "";
        generate(index,s,ans,n);
        Collections.sort(ans);
        return ans;
    }
    static void generate(int index, String s, List<String> ans, int n){
        for(int i=0; i<s.length()-1; i++){ // checks for consecutive 1s
            if(s.charAt(i)=='1' && s.charAt(i+1)=='1') return;
        }
        if(index==n){
            ans.add(s);
            return;
        }
        s = s + '1';
        generate(index+1,s,ans,n);
        s = s.substring(0,index) + '0';
        generate(index+1,s,ans,n);
    }
}
