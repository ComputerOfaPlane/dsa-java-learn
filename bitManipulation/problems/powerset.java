/*
print all subsets
truth table
*/
class Solution {
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        int n = 1<<a.length;
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<a.length; j++){
                if(((i>>j)&1)==1) temp.add(a[j]);
            }
            list.add(temp);
        }
        return list;
    }
}