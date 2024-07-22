/*

Takes an element and places it at the correct position
(for small and nearly sorted array)

Time Complexity = O(n^2) avg, and worst cases (sum of natural numbers)
                  O(n) for best case
Space  = O(1)

*/
class InserionSort
{
  /*
  Time Complexity = O(N^2) sum of n numbers best O(N)
  Space Complexity = O(N)
       auxiliary stack space.
  */
  public static void recursive_insertionSort(int arr[], int i, int n){
    
    if(n==1) return;

    int j=i;

    while(j>0 && arr[j-1]>arr[j]){
      int t=arr[j-1;]
      arr[j-1]=arr[j];
      arr[j]=t;
      j-=1;
    }

    recursive_insertionSort(arr,i+1,n);
  }
  public void insertionSort(int arr[], int n)
  {
      for(int i=0; i<n;i++){ // traversing the array
          
            int j=i;
          
            while(j>0 && arr[j-1]>arr[j]){ // placing the element at correct position
            
                int t = arr[j];
                arr[j] = arr[j-1];
                arr[j-1]=t;
                
                j--;
            }
        }
  }
}