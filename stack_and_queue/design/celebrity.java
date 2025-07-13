/*
A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people. A square matrix mat[][] (n*n) is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[1, 1, 0], [0, 1, 0], [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1st person. Therefore, 1 is the celebrity person. 

brute force is obvious:

optimal: 
we can have a two pointer approach

we take top = 0, bottom = n-1

if mat[top][down]==1 // this implies the dude at top knows the dude at bottom so the dude at top cannot be celebrity
if(mat[down][top]==1) // this implies the dude at down knows the dude at top so the dude at down cannot be celebrity
else if both do not know each other both can not be celebrity

now at the end if top>down no celebrity exitss

else top and down will land at the same index, verify the top dude if he is a legit celebrity for real or not
*/
class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int top = 0, down = mat.length-1;
        while(top<down){
            int up = mat[top][down];
            int low = mat[down][top];
            if(up==1) top++;
            else if(low==1) down--;
            else{
                top++;down--;
            }
        }
        if(top>down) return -1;
        for(int i=0; i<mat.length; i++){
            if(i==top) continue;
            if(mat[top][i]==1 || mat[i][top]==0) return -1;
        }
        return top;
    }
}