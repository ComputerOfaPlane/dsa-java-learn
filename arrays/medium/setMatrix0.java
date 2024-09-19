/*
You are given a matrix 'MATRIX' of dimension 'N' x 'M'. 
Your task is to make all the elements of row 'i' and column 'j' equal to 0 
if any element in the ith row or jth column of the matrix is 0.

brute:
run a nested loop, if a zero is detected mark the entire row&column with -1, skip zero though
(will not work if the matrix contains no.s other than 0,1)
for()
    for()
        if elm is zero?
            markcol()
            markrow()
for()
    for()
        set0s
time = O((n*m)*(n+m)+(n*m))
space  =O(1) no extra space needed

better>?
define 2 1d arrays of size n,m
if zero occurs anywhere mark the corresponding cell in the 2d arrays
    [ , , , , ]
  ** 0 1 1 1 1
  ** 1 1 1 0 1
  ** 1 1 1 1 1
for()
    for()
        detect zeros & mark it in both 1d array
for()
    for()
        if row[i] || col[j] == 1 set elm 0
time = O(2*n*m)
space = O(n+m)

best? O(1) space
store it within the marking within the array
    
   *
   0# 1* 1* 1* 1*
   1# 1 1 0 1
   1# 1 1 1 1

star * stores info for col
# stores info for row
run loops and mark the cells
then mark set the non info carrying cell based on marking
then mark the info carrying one
time = O(n*m)
space = O(1)

*/
class setMatrix0 {
    public void setZeroes(int[][] matrix) {
        int c0=1;
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0) matrix[0][j]=0;
                    else c0=0;
                }
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0) for(int j=0;j<c;j++) matrix[0][j]=0;
        if(c0==0) for(int i=0;i<r;i++) matrix[i][0]=0;
    }
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        int c0=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    matrix.get(i).set(0, 0);
                    if(j==0) c0=0;
                    else matrix.get(0).set(j,0);
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix.get(i).get(j)!=0){
                    if(matrix.get(i).get(0)==0 || matrix.get(0).get(j)==0) matrix.get(i).set(j,0);
                }
            }
        }
        if(matrix.get(0).get(0)==0) for(int i=0;i<m;i++) matrix.get(0).set(i, 0);
        if(c0==0) for(int i=0;i<n;i++) matrix.get(i).set(0, 0);
        return matrix;
    }
}