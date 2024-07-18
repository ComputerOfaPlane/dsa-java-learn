class SelectionSort
{
    
    void selectionSort(int arr[], int n)
    {
        /*

        Time Complexity = Sum of n naturl numbers O(n*(n-1)/2) or simply O(n^2)
        Space Complexity = O(1)

        Here we try to find the smallest element each time in the array
        and move it to the leftmost

        */
        
        for(int i=0;i<=n-2;i++){
            
            int minimum_index=i;
            
            for(int j=i+1; j<n; j++){
                
                if(arr[minimum_index]>arr[j]){
                    minimum_index = j;
                }
                
                
            }
            if(minimum_index!=i){
                int tmp = arr[i];
                arr[i]=arr[minimum_index];
                arr[minimum_index] = tmp;
            }
        }
    }
}