/*
Objective: Find all the elements which occurs in the array more than n/3 times where n is the size of the array

1. naive approach
pick one element, count its frequency, if the frequency is more add it to resultant data structure
do it for all elements in the array, be carefull to not add the same element many times
time complexity = O(n^2)
space = O(1) no additonal space required

observation: there can be at max two majority elements in the array who can occur more than n/3 times

2. better
use a hashmap to frequency count, if the element meets the threshold at any point add it in the data structure
time complexity: O(n) // considering the average of hashmap
space : O(n)

3. optimal:
use the concept of majority voting algo from n/2
where the algo was like
1. initialize count = 0, element = anything
2. loop for all array elements
3.      if count is zero
            increment count and element = curr element of the array
        else if element==curr then increment count
        else decrement count
4. check this element is major or not
as we observed we can only have two major elements in this case we can do the same thing but for two elements and counts
1. initialize c1=0, c2=0, elm1,elm2 as anything
2. loop
3.      if c1==0 and elm2!=curr c1++, elm1=curr
        else if c2==0 and elm1!=curr c2++, elm2=curr
        else if elm==elm1 c1++
        else if elm==elm2 c2++
        else c1--,c2--
        (this decrements actually counters the frequency)
time complextiy : O(n)
space : O(1)
*/
import java.util.*;
public class Solution {
    public List<Integer> majorityElement(int[] nums) { // optimal
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE, count1 = 0, count2 = 0, limit = nums.length/3;
        for(int i:nums){
            if(count1==0 && element2!=i){
                count1++;
                element1 = i;
            }
            else if(count2==0 && element1!=i){
                count2++;
                element2 = i;
            }
            else if(i==element1) count1++;
            else if(i==element2) count2++;
            else{
                count1--;
                count2--;
            }
            
        }
        count1 = 0; count2 = 0;
        for(int i:nums){
            if(i==element1) count1++;
            if(i==element2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1>limit) res.add(element1);
        if(count2>limit) res.add(element2);
        return res;
    }
    public static List< Integer > majorityElement(int []nums) {
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        int len = nums.length;
        int limit = len/3 + 1;
        List<Integer> res = new ArrayList<>();
        for(int i:nums){
            if(mp.containsKey(i)) mp.replace(i,mp.get(i)+1);
            else mp.put(i,1);

            if(mp.get(i)==limit) res.add(i);

            if(res.size()==2) break;
        }
        Collections.sort(res);
        return res;
    }
}