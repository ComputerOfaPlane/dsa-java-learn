import java.util.ArrayList;

class Subsequence {

    // Time complexity = O((2^n)*n)
    // space complexity = O(n)

    //                  index       data structure      array      size
    static void print1(int ind, ArrayList<Integer> ds, int arr[], int n){
        if (ind == n){
            System.out.println(ds.toString()); // O(n)
            return;
        }
        // element added
        ds.add(arr[ind]);
        print1(ind+1, ds,arr, n);
        ds.remove(ds.size()-1);
        
        // element removed
        print1(ind+1, ds,arr, n);
    }

    public static void main(String[] args) {
        int arr[] = {3,1,2};
        int len=arr.length;
        ArrayList<Integer> ds = new ArrayList<>();
        
        print1(0,ds,arr,len);
    }
}