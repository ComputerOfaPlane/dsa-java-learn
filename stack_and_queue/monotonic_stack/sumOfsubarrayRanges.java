/*
just like sum of subarray minimums,

we have to solve this question as 

ssum of subarray maximums - sum of subarray minimums

find nse,pse,nge,pge


*/
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long smax = smax(nums,n);
        long smin = smin(nums,n);
        // System.out.println(smax+" - "+smin);
        return smax - smin;
    }
    static long smax(int nums[], int n){
        long ans = 0L;
        int pge[] = pge(nums,n);
        int nge[] = nge(nums,n);
        // System.out.println("pge = "+Arrays.toString(pge));
        // System.out.println("nge = "+Arrays.toString(nge));
        for(int i=0; i<n; i++){
            int left = i-pge[i];
            int right = nge[i]-i;
            ans += (1L*left*right*nums[i]);
        }
        return ans;
    }
    static long smin(int nums[], int n){
        long ans = 0L;
        int pse[] = pse(nums,n);
        int nse[] = nse(nums,n);
        // System.out.println("pse = "+Arrays.toString(pse));
        // System.out.println("nse = "+Arrays.toString(nse));
        for(int i=0; i<n; i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            ans += (1L*left*right*nums[i]);
        }
        return ans;
    }
    static int[] nse(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; --i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>=elm) stack.pop();
            ans[i] = (stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] pse(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; ++i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>elm) stack.pop();
            ans[i] = (stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] nge(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; --i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<=elm) stack.pop();
            ans[i] = (stack.isEmpty())?n:stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] pge(int nums[], int n){
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; ++i){
            int elm = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<elm) stack.pop();
            ans[i] = (stack.isEmpty())?-1:stack.peek();
            stack.push(i);
        }
        return ans;
    }
}