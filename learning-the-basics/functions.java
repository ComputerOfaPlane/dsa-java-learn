import java.util.Arrays;

class function {
    static class Member {
        String s;
    }
    static void passByValue(int c){
        c+=10; // no changes  will be made
    }
    static void reference(int[] arr, Member a) {
        arr[1] = 0;
        a.s = a.s + " gupta";
    }

    public static void main(String[] args) {

        Member obj = new Member();
        int[] myArray = {42, 42, 42, 42, 42, 42};
        obj.s = "aniket";
        int k=10;
        
        reference(myArray, obj);
        passByValue(k); // a copy of the int var is created and the func works on that copy

        System.out.println(Arrays.toString(myArray)); // [42, 0, 42, 42, 42, 42]
        System.out.println(obj.s); // aniket gupta
        System.out.println(k);
    }
}
/*
Note:
Arrays and objects are passed by value, where the value passed is a reference to the actual object. 
This means the method receives a copy of the reference, allowing it to modify the object's data, 
but it cannot change the original reference to point to a different object.

Pass by Value:
In Java, pass by value means that when you pass a variable to a method, you are passing a copy of the value of that variable.

!!! Java does not support pass by reference, where a method would receive a reference to the actual variable itself, 
    allowing the method to change the caller's variable directly.

Pass by Reference: (array & objects)
For objects, Java passes a copy of the reference (address) of the object. This might look like pass by reference, 
but it is still pass by value because the reference itself is passed by value.

*/