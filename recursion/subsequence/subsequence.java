/*
write a java code that prints all the subsequence of an integer array

lets say we have an integer array of length n = 5

{ _ , _ , _ , _ , _ }

we can take all the elements in the 5 places

we can take any 4 places in order and reject the rest 

we can take any 2 places and reject the rest

or we reject everything

this would generate 2^n subsequences


the idea of the code is

f(){
when index==size return;
take the element at the index
f(index+1)
not take the element at that particular index
f(index+1)
}

*/
import java.util.*;
class TUF{
    static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String args[]){
        String s="abc";
        ArrayList<String>ans = AllPossibleStrings(s);
        //printint all the subsequence.
        System.out.println("All possible subsequences are ");
        for (String it : ans) {
            System.out.print( it+" ");
        }
    }
}