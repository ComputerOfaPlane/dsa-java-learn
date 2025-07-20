/*
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.


as we can only take elements from corner and they must be k
we can have a sliding window approach, like
take k from left, 0 from right
take k-1 from left, 1 from right
...
take 0 from left, k from right

*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, len = cardPoints.length, left=k-1, right = len-1;
        for(int i=0; i<k; i++) sum+=cardPoints[i];
        // System.out.println(sum);
        int max = sum;
        for(int i=0; i<k; i++){
            sum-=cardPoints[left];
            left-=1;
            sum+=cardPoints[right];
            right-=1;
            // System.out.println(sum);
            max = Math.max(max,sum);
        }
        return max;
    }
}