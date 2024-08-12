/*
in this problem we need to rearrange elements of the array such that their signs are alternating
variety> the no. of positive and negatives are equal
variety> the no. of positive and negatives are unequal
*/

/*
approach:
store the positive and negatives in separate lists
then add it to the ans accordingly
time=O(n)+O(n)
space = O(n) // storing posi and negative

if positives is equal to negatives:
keep 2 pointers, one pointing at places for posi nums other for negi nums
traverse the array and if posi add in posi and update pointer
else add in negi position and update pointer
time = O(n)
space = O(n)
*/
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static int[] alternateNumbers(int []a) {
        List<Integer> posi=new ArrayList<>();
        List<Integer> negi=new ArrayList<>();

        for(int i:a){
            if(i<0) negi.add(i);
            else posi.add(i);
        }

        int min = Math.min(posi.size(), negi.size());
        int max = Math.max(posi.size(), negi.size());

        for(int i=0;i<min;i++){
            a[i*2]=posi.get(0);
            posi.remove(0);
            a[i*2+1]=negi.get(0);
            negi.remove(0);
        }
        if(posi.size()==0 && negi.size()==0) return a;
        posi.addAll(negi);

        for(int i=min+1;i<min+max;i++){
            a[i]=posi.get(0);
            posi.remove(0);
        }
        return a;
    }
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        int positive=0,negative=1;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                ans[negative]=nums[i];
                negative+=2;
            }
            else{
                ans[positive]=nums[i];
                positive+=2;
            }
        }
        return ans;
    }
}