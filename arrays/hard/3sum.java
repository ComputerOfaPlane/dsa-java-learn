/*
Three Sum problem: the sum of unique triplets must be equal to zero or to something needed

brute force solution:
iterate over each triplet and add them to a set in sorted fashion

better:
we need to find i+j+k=0
this can be re-written as j=-(i+k)
we can set i as some initial index, k as i+2, then add the middle elements in a set for the time being
if the set contains -(i+k) at any moment we found a triplet, add this to our answer set

optimal solution:
the main problem we were facing was constantly sorting the triplets and making sure they were unique before storing them in answer.
what this solution does is, it sorts the array and sets three pointers
i = 0 : 0->n
j = i+1 <k
k= n-1 >j
for each index i, we set j=i+1, k=n-1 and iterate as long as j<k
we calculate the sum, if sum is more than required, we need to decrement k, if sum is less than required we need to increment j
if sum is exactly as needed, we add the triplet
and search for more by setting j and k to an index where j<k and value of j and k are not what they were previously
*/
import java.util.*;
class Solution {
    public List<List<Integer>> OptimalthreeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int j=i+1, k=n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0) k--;
                else if(sum<0) j++;
                else{
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                    j++;k--;
                    ans.add(list);
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> BetterthreeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> uni = new HashSet<>();
        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i+2; j<n; j++){
                set.add(nums[j-1]);
                int needed = -(nums[i]+nums[j]);
                if(set.contains(needed)){
                    List<Integer> list = Arrays.asList(nums[i],needed,nums[j]);
                    list.sort(null);
                    uni.add(list);
                }
            }
        }
        return new ArrayList(uni);
    }
    public List<List<Integer>> bruteForceThreeSum(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        Collections.sort(list);
                        if(!set.contains(list)){
                            ans.add(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return ans;
    }
}