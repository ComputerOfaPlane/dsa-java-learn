/*
The four sum problem: find all unique quads whose sum is equal to target

brute force: iterate over each quads one by one at the same time maintaining a set to make sure each of the quad added to the answer is unique

better:
using the same concept from three Sum:
we needed to find i+j+k=0
this can be re-written as j=-(i+k)
we can set i as some initial index, k as i+2, then add the middle elements in a set for the time being
if the set contains -(i+k) at any moment we found a triplet, add this to our answer set.
for this four Sum we i+j+k+l=target
this was re-written as k = target-(i+j+l), the middle elements were added in a set, if set contained this then we had a quad and add it to set it sorted manner

optimal:
using the same concept from optimal solution of three sum problem where we,
sorted the array, fixed three pointer i=0, j=i+1, and k = n-1
i iterated from 0 to n remaining fixed while j and k adjusted to make sum 0
in four sum problem a,b,c,d
here, we fix a and b, set c = b+1 and d = n-1;
calculate sum if sum is more than target d--, if sum is less than target c++
else quad is found, since array is already sorted duplicates can be easily avoided without needing a set
*/
import java.util.*;
class Solution {

    public List<List<Integer>> BestFourSum(int[] nums, int target) {
        long t = target;
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j>(i+1) && nums[j]==nums[j-1]) continue;
                int mid=j+1, k=n-1;
                while(mid<k){
                    long sum = (long)nums[i]+nums[j]+nums[mid]+nums[k];
                    if(sum>t) k--;
                    else if(sum<t) mid++;
                    else{
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[mid],nums[k]);
                        ans.add(list);
                        mid++;
                        k--;
                        while(mid<k && nums[mid]==nums[mid-1]) mid++;
                        while(mid<k && nums[k]==nums[k+1]) k--;
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> BetterFourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Set<Long> mid = new HashSet<>();
                for(int k=j+2; k<n; k++){
                    mid.add((long)nums[k-1]);
                    long needed = (long)target-nums[i]-nums[j]-nums[k];
                    if(mid.contains(needed)){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],(int)needed);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList(set);
    }

    public List<List<Integer>> BruteFourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        int sum = nums[i]+nums[j]+nums[k]+nums[l];
                        if(sum==target){
                            List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            list.sort(null);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}