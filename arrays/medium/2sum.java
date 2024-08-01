/*
in an array find 2 numbers which add to give a sum equals to the target

brute force:
run a nested loop for every element in the array except itself
and find sum and compare:
for(i->n)
    for(j->n)
        sum=a[j]+a[i]
        compare this with target
time = O(n^2)
space = O(1)

better:
use a hashmap
traverse through the array
find needed and search it in map
time = O(n) generally for unordered but may take O(n^2)
       O(nlogn) for ordered map
space = O(n)
*/
class Solution {
    public static int[] twoSum(int[] nums, int target) {

        int t[]=new int[2];
        
        HashMap<Integer, Integer> m=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            int elm = nums[i];

            int needed = target-elm;

            if(m.containsKey(needed)){
                t[0]=m.get(needed);
                t[1]=i;
                break;
            }
            m.put(elm,i);
        }
        return t;
    }
}

/*
if we just want a boolean result we can just short the array
and have a 2 pointer greedy approach

int left = 0, right = n - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) {
        return "YES";
    } else if (sum < target) left++;
    else right--;
}
return "NO";

have 2 pointers at left and right extreme
if sum is less than target increase left else if more decrease right
time = O(nlogn) + O(n)
space = O(1)
*/