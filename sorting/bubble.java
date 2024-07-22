class BubbleSort
{
    /*
    Placing the largest elements at correct spot with adjacent swapping

    time complexity = O(N^2) sum of n natural numbers
                    best case = O(N)
    space complexity = O(1)


    */
    public static void recursive_bubble(int arr[], int n){

        /*
            Time Complexity = O(N^2)
                    O(N2) for the worst and average cases and O(N) for the best case. Here, N = size of the array.
                    sum of n natural numbers
            Space Complexity = O(N)
                    O(N) auxiliary stack space.
        */
        if(n==1) return;
        
        boolean didswap = false;
        
        for(int i=0; i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int tmp= arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=tmp;
                
                didswap = true;
            }
        }
        
        if(!didswap) return;
        
        bubbleSort(arr,n-1);
    }
    public static void bubbleSort(int arr[], int n)
    {
        for(int i=n-1; i>=1; i--){
            int didswap=0;
            for(int j=0; j<=i-1; j++){
                
                if(arr[j+1]<arr[j]){
                    int t=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=t;
                    didswap=1;
                }
                if(didswap==1) break;
            }
        }
        
        /*
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
        */
    }
}