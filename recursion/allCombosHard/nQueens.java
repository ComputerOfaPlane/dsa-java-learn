/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

approach: try placing queens in every possible cell

iterate over a column 1, place a queen if it is possible to place
then move to the next column
check for validity

checking validity can be optimised using hashing
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char arr[][] = new char[n][n];
        boolean rowmap[] = new boolean[n];
        boolean mdiag[] = new boolean[2*n-1];
        boolean secdia[] = new boolean[2*n-1];
        for(int i=0; i<n; i++) for(int j=0; j<n; j++) arr[i][j] = '.';
        generate(0,ans,n,arr,rowmap,mdiag,secdia);
        return ans;
    }
    static void generate(int col, List<List<String>> ans, int n, char arr[][], boolean rowmap[], boolean mdiag[], boolean secdia[]){
        if(col==n){
            List<String> list = new ArrayList<>();
            for(char a[]:arr) list.add(new String(a));
            ans.add(list);
            return;
        }
        for(int i=0; i<n; i++){
            if(
                !rowmap[i] && !secdia[i+col] && !mdiag[(n-1)+(col-i)]
            ){
                arr[i][col] = 'Q';
                rowmap[i] = true;
                secdia[i+col] = true;
                mdiag[(n-1)+(col-i)] = true;
                generate(col+1,ans,n,arr,rowmap,mdiag,secdia);
                arr[i][col] = '.';
                rowmap[i] = false;
                secdia[i+col] = false;
                mdiag[(n-1)+(col-i)] = false;
            }
            /*if(valid(i,col,arr,n)){
                arr[i][col] = 'Q';
                generate(col+1,ans,n,arr);
                arr[i][col] = '.';
            }*/
        }
    }
    /*static boolean valid(int row, int col, char arr[][], int n){
        int r = row, c = col;
        while(row>=0 && col>=0){
            if(arr[row][col]=='Q') return false;
            row--; col--;
        } 
        row = r; col =c;
        while(col>=0){
            if(arr[row][col]=='Q') return false;
            col--;
        }
        row = r; col = c;
        while(row<n && col>=0){
            if(arr[row][col]=='Q') return false;
            row++; col--;
        } 
        return true;
    }*/
}