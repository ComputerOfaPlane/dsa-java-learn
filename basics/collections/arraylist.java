import java.util.ArrayList;
import java.util.List;


/*
ArrayList internally implements arrays

if size  = n
and it overflow then size = n + n/2 +1
and copies all elements to this new array

// time complexity:

remove = O(n)

adding:
    - adding element at end when space is availabe O(1)
    - adding when array is full O(n)
    - adding at an index O(n)

*/

class LearnArrayList {

    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();

        String data1 = "aniket";
        String data2 = "gupta";

        list.add(data1); // adds element to end of list
        list.add(data2);
        list.add(data1);
        list.add(data1);
        // [aniket, gupta, aniket, aniket]

        // add at a particular position
        int index = 2;
        String data3="java";
        list.add(index,data3);
        // [aniket, gupta, java, aniket, aniket]
        

        // fetch elements
        String fecthed = list.get(index);
        System.out.println(fecthed);
        //java

        System.out.println(list);
        // [aniket, gupta, java, aniket, aniket]

        list.add("30");
        System.out.println(list);

        // remove
        list.remove(index); // removes java @ index 2

        // remove element
        // list.remove(WrapperClass.valueOf(same data type element to be removed))
        list.remove(String.valueOf("30"));

        System.out.println(list);

        List<String> newlist = new ArrayList<>(); // see note below

        newlist.add("1");
        newlist.add("1");
        newlist.add("1");
        newlist.add("1");

        list.addAll(newlist); // joins two list (data type should be same)

        System.out.println(list);
        // [aniket, gupta, aniket, aniket, 1, 1, 1, 1]

        // clear the list
        list.clear();
        System.out.println(list);

        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        // update element
        list.set(index, data1); // O(1)
        System.out.println(list);

        // check if element is present?
        System.out.println( list.contains(data2) ); // O(N)

        // size
        int len = list.size(); // O(1)

        // iterating the list
        for (int i=0; i<list.size() ;i++ ) {
            System.out.println(list.get(i));
        }
        for(String element: list){
            System.out.println(element);
        }
    }
}
/*
ArrayList<Integer> list = new ArrayList<>();

Here, ArrayList<Integer> is explicitly specifying that list is an instance of ArrayList that holds Integer objects.
This approach provides specific methods and behaviors that are unique to ArrayList, such as ensureCapacity,
which is used to preallocate memory for performance reasons.
Using ArrayList<Integer> directly also allows you to easily cast to ArrayList methods if needed.

List<Integer> list = new ArrayList<>();

Here, List<Integer> is an interface type that references an ArrayList.
This approach is more flexible because it allows you to change the implementation class later without affecting the rest of the code.
For example, you could switch ArrayList to LinkedList or any other class that implements the List interface without changing the type of list.

*/