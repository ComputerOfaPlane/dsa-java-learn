import java.util.Arrays;

class Reverse {
    static void recrev(int arr[], int i, int j) // recursive reverse
    {
        if(i>j) return;
        int tmp= arr[i];
        arr[i] = arr[j];
        arr[j]=tmp;
        recrev(arr,i+1,j-1);
    }
    static void recrev(int arr[], int i) // recursive reverse with just 1 param
    {
        // same as above fn but with 1 less param

        int j=arr.length-i-1; // if you remove -i it'll reverse entire thing onwards i

        if(i>j) return;
        int tmp= arr[i];
        arr[i] = arr[j];
        arr[j]=tmp;
        recrev(arr,i+1,j-1);
    }
    static void rev(int arr[]){ // reverses the entire array
        
        int front = 0;
        int back = arr.length-1;
        
        while(front<=back){
            
            int tmp= arr[front];
            arr[front] = arr[back];
            arr[back]=tmp;
            front+=1;
            back-=1;
        }
    }
    static void rev(int arr[], int i, int j){ // reverses from a particular index to other index
        
        int front = i;
        int back = j;
        
        while(front<=back){
            
            int tmp= arr[front];
            arr[front] = arr[back];
            arr[back]=tmp;
            front+=1;
            back-=1;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        rev(arr);
        System.out.println(Arrays.toString(arr));
        recrev(arr,2,6);
        System.out.println(Arrays.toString(arr));
    }
}