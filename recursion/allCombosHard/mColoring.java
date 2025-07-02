/*
You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:

1. make a temporary array that stores the current colors
3. check for validity
3. assign a color to a node between 1 to m
4. recurse for the next node
*/
class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int color[] = new int[v];
        return is(0,v,edges,m, color);
    }
    static boolean is(int index, int v, int edges[][], int m, int color[]){
        if(index==v) return true;
        for(int i=1;i<=m; i++){
            if(possible(index,i,edges,color)){
                color[index] = i;
                if(is(index+1,v,edges,m,color)) return true;
                color[index] = 0;
            }
        }
        return false;
    }
    static boolean possible(int index, int c, int edges[][], int color[]){
        for(int edge[]:edges){
            int a = edge[0];
            int b = edge[1];
            if(index==a){
                if(color[b]==c) return false;
            }
            if(index==b){
                if(color[a]==c) return false;
            }
        }
        return true;
    }
}