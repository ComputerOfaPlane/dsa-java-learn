import java.util.*;

/*
        DIVDE AND MERGE

divide upto the smallest element and then merge them as two sorted arrays


Time Complexity :: O(n.log_2(n))
Space Complexity : O(n)

*/
class MergeSortLearn
{
    void merge(int arr[], int l, int m, int r)
    {
        int left = l;
        int right = m+1;
        
        List<Integer> list = new ArrayList<>();
        
        // merging two sorted array and storing in the third array
        while(left<=m && right<=r){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left+=1;
            }
            else{
                list.add(arr[right]);
                right+=1;
            }
        }
        while(left<=m){
            list.add(arr[left]);
            left+=1;
        }
        while(right<=r){
            list.add(arr[right]);
            right+=1;
        }

        //copying back to original array
        for(int i=l,j=0; i<=r;i++,j++){
            arr[i]=list.get(j);
        }
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l>=r) return;
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}