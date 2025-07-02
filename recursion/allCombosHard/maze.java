/*
maze solver:

a rat is placed on 0,0 cell of a matrix, and it can do either of the following
up, down, left, right

if the cell is 0 it is a wall and does not allow movement
if the cell is 1, it can allow movement to that cell

approach:
base condition:
    check for overflow of index
    if found add to ans
    if cell is already visited or not allowed to be moved to return
else mark the cell as visited
then do recursion for each movement operation
remove the marker from visited
*/
class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int row = maze.length, col = maze[0].length;
        boolean visited[][] = new boolean[row][col];
        fill(0,0,"",visited,maze,row,col,ans);
        // Collections.sort(ans);
        return ans;
    }
    static void fill(int curr_row, int curr_col, String s, boolean visited[][], int maze[][], int row, int col, ArrayList<String> ans){
        boolean condition = curr_row<0 || curr_row>=row || curr_col<0 || curr_col>=col;
        if(condition) return;
        if(curr_row==row-1 && curr_col==col-1){
            ans.add(s);
            return;   
        }
        if(visited[curr_row][curr_col] || maze[curr_row][curr_col]==0) return;
        
        visited[curr_row][curr_col] = true;
        
        fill(curr_row+1,curr_col,s+'D',visited,maze,row,col,ans);
        fill(curr_row,curr_col-1,s+'L',visited,maze,row,col,ans);
        fill(curr_row,curr_col+1,s+'R',visited,maze,row,col,ans);
        fill(curr_row-1,curr_col,s+'U',visited,maze,row,col,ans);
        
        visited[curr_row][curr_col] = false;
        
        return;
    }
}