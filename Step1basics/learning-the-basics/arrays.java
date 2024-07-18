import java.util.Arrays;

class arrays{
    public static void main(String[] args) {

        // initialization

        // 1d
        int[] myArray;
        // int[] a,b,c; a,b&c are arrays
        // int a[],b,c; just a is an array

        myArray = new int[5];

        int[] myArray1 = new int[5];

        // 2d
        int[][] matrix = new int[3][4]; // 3 rows and 4 columns
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // accessing through zero based indices

        int firstElement = myArray1[0]; // Access the first element
        myArray[2] = 10; // Modify the third element

        int value = matrix1[1][2]; // Access element at row 1, column 2
        matrix[0][1] = 5; // Modify element at row 0, column 1

        // length 
        int length = myArray.length; // Length of the array
        int rows = matrix.length; // Number of rows
        int columns = matrix[0].length; // Number of columns in the first row

        // iterating through array or traversing
        // 1d
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
        // enhanced for
        for (int element : myArray) {
            System.out.println(element);
        }
        // 2d
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for(int[] inner: matrix){
            for(int valu: inner){
                System.out.println(valu);
            }
        }

        // operations on arrays

        // copying
        int[] copy = Arrays.copyOf(myArray, myArray.length);

        // sorting
        Arrays.sort(myArray);

        // fill array (fills with same element)
        Arrays.fill(myArray, 42); // Fills the array with the value 42
        /*
            Syntax:
                // Makes all elements of a[] equal to "val"
                public static void fill(int[] a, int val)

                // Makes elements from from_Index (inclusive) to to_Index
                // (exclusive) equal to "val"
                public static void fill(int[] a, int from_Index, int to_Index, int val)

                This method doesn't return any value.
        */
        // https://www.geeksforgeeks.org/arrays-fill-java-examples/

        // searching in sorted array
        int index = Arrays.binarySearch(myArray, 3); // Assumes the array is sorted

        // equality check
        boolean isEqual = Arrays.equals(myArray, myArray1);

        // converting to string
        String arrayString = Arrays.toString(myArray);
    }
    int delete(int arr[], int index, int len){
        if(len==0){
            return -999;
        }
        else if(len-1==index){
            arr[index]=0;
        }
        else{
            for (int i=index; i<len-1 ;i++ ) {
                arr[i]=arr[i+1];
            }
        }
        return len-1;
    }
    int insert(int arr[], int val, int index, int len){
        if(arr.length==len){
            return -999;
        }
        else if(len==index){
            arr[index]=val;
        }
        else{
            int temp = len;
            while(temp>index){
                arr[temp]=arr[temp-1];
                temp--;
            }
            arr[index]=val;
        }
        return len+1;
    }
}