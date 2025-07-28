/*
find the valid ranges
*/
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length(), min = 0, max = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(':
                    min+=1;
                    max+=1;
                    break;
                case ')':
                    min-=1;
                    max-=1;
                    break;
                default:
                    min-=1;
                    max+=1;
                    break;
            }
            if(min<0) min=0;
            if(max<0) return false;
        }
        return min==0;
    }
}
/*
recursive solution
class Solution {
    public boolean checkValidString(String s) {
        return is(0,s,0);
    }
    static boolean is(int index, String s, int counter){
        if(counter<0) return false;
        if(index==s.length()){
            return counter==0;
        }
        char ch = s.charAt(index);
        switch(ch){
            case '(':
                return is(index+1,s,counter+1);
            case ')':
                return is(index+1,s,counter-1);
            default:
                boolean is1 = is(index+1,s,counter-1) || is(index+1,s,counter+1) || is(index+1,s,counter);
                return is1;
        }
    }
}
*/