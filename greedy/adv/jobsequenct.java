/*
sort by profit, and try to fill the slots before the deadline
not optimal but can be optimised using dsu
*/
class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = profit.length;
        int arr[][] = new int[n][2];
        int max = -1;
        for(int i=0; i<n; i++){
            max = Math.max(max,deadline[i]);
            arr[i][0] = deadline[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(b[1],a[1]));
        boolean is[] = new boolean[max];
        int ans = 0, c=0;
        for(int i=0; i<n; i++){
            int dead = arr[i][0];
            int prof = arr[i][1];
            for(int j=dead-1; j>=0; j--){
                if(!is[j]){
                    c++;
                    ans += prof;
                    is[j] = true;
                    break;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(c);
        list.add(ans);
        return list;
    }
}