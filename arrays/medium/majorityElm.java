/*

Problem:
an array is given we need to find the element which occurs more than n/2 times

brute:
run a nested loop and check for each element its count
time = O(n^2)
space = O(1)

better: hashing
traverse the array and remember the freq in the map
traverse the map to find out
time = O(n . 1)traverse the array and push element in unordered case(best and avg) + O(n) find the element or O(n.n)+O(n)
       O(n . logn) for ordered map + O(n)
space = O(n)

best:(Moore’s Voting Algorithm:)

maintain 2 variables  count and element
count  = 0
run thru the array
if count is 0
    element=curr element
    count=1
else if cuurent element = element
    count++
else count --
run thru the loop to confirm if the element is in majority
time = O(n) + O(n) //second one only needed to find the element or count
space = O(1)
*/
class Solution {
    public int majorityElement(int[] nums) {
        /* HashMap<Integer,Integer> m=new HashMap<>();
        for(int i:nums){
            if(m.containsKey(i))    m.replace(i,m.get(i)+1);
            else    m.put(i,1);
        }
        int n=nums.length;
        for(int key:m.keySet()){
            int a=m.get(key);
            if(a>n/2) return key;
        }
        return -1; */

        int count =0;
        int elm=-1;
        for(int i:nums){
            if(count==0){
                count=1;
                elm=i;
            }
            else if(elm==i) count++;
            else count--;
        }
        count=0;
        for(int i:nums){
            if(i==elm) count++;
        }
        if(count>nums.length/2) return elm;
        return -1;
    }
}