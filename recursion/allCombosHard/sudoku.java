/*
given an incomplete sudoku board, fill the sudoku board with the correct answers
*/
class Solution {
    public void solveSudoku(char[][] board) {
        fill(board);
    }
    static boolean fill(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char ch = board[i][j];
                if(ch=='.'){
                    for(char k='1'; k<='9'; k++){
                        if(is(i,j,board,k)){
                            board[i][j] = k;
                            if(fill(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean is(int row, int col, char board[][], char k){
        int grouprowhead = 3 * (row/3), groupcolhead = 3 * (col/3);
        for(int i=0; i<9; i++){
            if(board[row][i]==k) return false;
            if(board[i][col]==k) return false;
            if(board[grouprowhead + i/3][groupcolhead + i%3]==k) return false;
        }
        return true;
    }
}