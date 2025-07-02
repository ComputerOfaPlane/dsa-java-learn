/*
find words in a matrix, this question is similar to rat in a maze questions
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<row; i++) for(int j=0; j<col; j++) if(board[i][j]==word.charAt(0)) list.add(new int[]{i,j});
        for(int x[]:list){
            int a = x[0], b = x[1];
            boolean visited[][] = new boolean[row][col];
            if(is(a,b,row,col,word,0,board,visited)) return true; 
        }
        return false;
    }
    static boolean is(int i, int j, int row, int col, String word, int index, char board[][], boolean visited[][]){
        if(index==word.length()) return true;
        boolean overflow = i<0 || i>=row || j<0 || j>=col;
        if(overflow) return false;
        if(word.charAt(index)!=board[i][j] || visited[i][j]) return false;

        visited[i][j] = true;

        if(is(i+1,j,row,col,word,index+1,board,visited)) return true;
        if(is(i-1,j,row,col,word,index+1,board,visited)) return true;
        if(is(i,j-1,row,col,word,index+1,board,visited)) return true;
        if(is(i,j+1,row,col,word,index+1,board,visited)) return true;

        visited[i][j] = false;

        return false;
    }
}