/*
generate all permutations of an array
*/
/*
create a map where each cell in the array maps to an index in the array and stores whether that particular cell element have been picked or not

when that element is picked do index+1 and mark that cell as visited

keep adding unvisited cells to the list
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // int visited[] = new int[nums.length];
        generate(nums,new ArrayList<>(),ans);
        return ans;
    }
    static void generate(int nums[], List<Integer> list, List<List<Integer>> ans){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=Integer.MIN_VALUE){
                list.add(nums[i]);
                int t = nums[i];
                nums[i] = Integer.MIN_VALUE;
                generate(nums,list,ans);
                list.remove(list.size()-1);
                nums[i]=t;
            }
        }
    }
}
/*better approach with O(1) space

we try to swap in place

lets say for array {1, 2, 3}

first element is '1' swap '1' with 1,2,3

then what we obtain for each place

swap the second place for 1,2,3

and so on
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // int visited[] = new int[nums.length];
        generate(0,nums,ans);
        return ans;
    }
    static void generate(int index, int nums[], List<List<Integer>> ans){
        if(index==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i:nums) list.add(i);
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(nums,i,index);
            generate(index+1,nums,ans);
            swap(nums,i,index);
        }
    }
    static void swap(int a[], int i, int j){
        int t = a[i];
        a[i]  = a[j];
        a[j] = t;
    }
}
