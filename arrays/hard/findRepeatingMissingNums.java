/*
you are given an array of size n which is supposed to contain numbers from 1 to n in any order
but in the given array one number is missing, and instead we have a repeating number
we need to find both of the missing and repeating number and return them in the array

brute: run a loop from 1 to n and search each of this in the array

better: use a hashmap, or hashset

best1 approach1: use math
find the sum of the array = S
find the sum of the squares of the array = S2

sum of n natural number = n(n+1)/2
sum of squares of n natural number = (n*(n+1)*(2n+1))/6

form two linear equations and solve them to get x and y


best2 approach: use bitmasking, revisit after doing bitmasks
*/
class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long sum = 0, sqrSum = 0;
        long n = grid.length;
        long total = n * n;

        // Calculate actual sum and squared sum from grid
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                sum += grid[row][col];
                sqrSum += (long) grid[row][col] * grid[row][col];
            }
        }

        // Calculate differences from expected sums
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long sumDiff = sum - (total * (total + 1)) / 2;
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;

        return new int[] { repeat, missing };
    }
    ArrayList<Integer> findTwoElement(int arr[]) {
        int xora = 0, extra = 0;
        boolean set[] = new boolean[1000001];
        int j = 1;
        for(int i:arr){
            if(!set[i]){
                xora^=(i^j++);
                set[i]=true;
            }
            else extra = i;
        }
        xora^=j;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(extra);
        list.add(xora);
        return list;
    }
}