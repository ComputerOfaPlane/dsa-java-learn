// https://www.tutorialspoint.com/java/lang/java_lang_string.htm

class strings {
    public static void main(String[] args) {
        
        // creating strings
        String str = "Hello world";

        String str2 = new String("Hello World");

        String str3;
        str3 = "Hello World";

        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str4 = new String(charArray);

        byte[] byteArray = {72, 101, 108, 108, 111}; // ASCII values
        String str5 = new String(byteArray);

        // common string fn()s

        // length
        int length = str.length();

        // concat
        String str1 = "Hello";
        str2 = str1.concat(", World!"); // str2 is "Hello, World!"
        // str1 remains "Hello"

        // character at specific index
        char ch = str.charAt(0); // First character
        ch = str.charAt(6); // First character -> 'W'

        // substring
        String substr = str.substring(0, 5); // "Hello"

        // equals check
        boolean isEqual = str1.equals(str2); // Case-sensitive
        boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2); // Case-insensitive

        // comparisons
        int comparison = str1.compareTo(str2); // Lexicographical comparison
        int comparisonIgnoreCase = str1.compareToIgnoreCase(str2); // Case-insensitive
        /*
            0 if the strings are equal
            diff in length then len(str1)-len(str2)
            if length is equal then diff in ascii values
                loop until a diff char encounter and return diff in ascii value
        */

        // search
        int index = str.indexOf('H'); // First occurrence of 'H'
        int lastIndex = str.lastIndexOf('o'); // Last occurrence of 'o'
        boolean contains = str.contains("Hello"); // Check if "Hello" is in the string

        // replace
        String replacedStr = str.replace('o', 'a'); // Replace all 'o' with 'a'
        String replacedStrAll = str.replaceAll("Hello", "Hi"); // Replace all "Hello" with "Hi"
        /*
            replace():
                The replace() method replaces all occurrences of a specified character or substring with another character or substring.
                It does not support regular expressions.
            
            replaceAll():
                The replaceAll() method replaces each substring of this string that matches the given regular expression with the given replacement.
                It supports regular expressions, making it more powerful for pattern-based replacements.
                
                SAmple:
                public class Main {
                    public static void main(String[] args) {
                        String str = "Hello World 123";
                        
                        // Replacing all digits with '#'
                        String result = str.replaceAll("\\d", "#");
                        System.out.println(result); // Hello World ###
                        
                        // Replacing a pattern (all words)
                        String result2 = str.replaceAll("\\b\\w+\\b", "X");
                        System.out.println(result2); // X X ###
                    }
                }
        */

        // trim
        String trimmedStr = str.trim(); // Remove leading and trailing spaces

        // split
        String[] words = str.split(" "); // Split by spaces
        // split() takes in regular expression as parameter
        // for eg: str.split("[+-*/ ]")

        // change case 
        String upperStr = str.toUpperCase(); // Convert to uppercase
        String lowerStr = str.toLowerCase(); // Convert to lowercase

        // conert to char array
        char[] charArray1 = str.toCharArray(); // Convert to character array

        // string formatting
        /*
        System.out.printf("The value of the float variable is " +
        "%f, while the value of the integer " +
        "variable is %d, and the string " +
        "is %s", floatVar, intVar, stringVar);

        or

        String fs;
        fs = String.format("The value of the float variable is " +
           "%f, while the value of the integer " +
           "variable is %d, and the string " +
           "is %s", floatVar, intVar, stringVar);
        System.out.println(fs);
        */

        // string to ascii array
/*
import java.util.Arrays;

public class GetByte {
   public static void main(String[] args) {
      
      //instantiate the string class
      String str = new String("Hello World");
      System.out.println("The given string is: " + str);
      
      // create a byte array
      byte[] byte_arr;
      
      // using getBytes() method
      byte_arr = str.getBytes();
      
      // print the byte array value
      System.out.println("The byte array is: " + Arrays.toString(byte_arr));
   }
}

The given string is: Hello World
The byte array is: [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
*/

        // hashCode()
        int hash = str.hashCode(); // generates hash value for a string

        // any data type to string
        // String.valueOf(i) // anything to string
        //String.toString(i) // preferrably numbers to string

        // str.isEmpty() => checks iif empty
        // str.startsWith(prefix) => boolean
        // str.endsWith(suffix) => boolean

/*
str.copyValueOf()
public static String copyValueOf(char[] data)// first syntax
public static String copyValueOf(char[] data, int offset, int count)// second syntax
*/

/*
Java uses a string pool to optimize memory usage. String literals are interned, meaning they are stored in a common pool.
When you create a string literal, Java checks the pool first.
If the string already exists, the reference to the existing string is returned.

String str1 = "Hello";
String str2 = "Hello";
boolean isSameReference = (str1 == str2); // true, both refer to the same object

You can explicitly intern a string using the intern method, which adds the string to the string pool.
String str1 = new String("Hello").intern();
String str2 = "Hello";
boolean isSameReference = (str1 == str2); // true

*/

        // For mutable strings, Java provides StringBuilder and StringBuffer.
        
        // String Builder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        String result = sb.toString(); // "Hello, World!"

        // String Buffer
        // StringBuffer is similar to StringBuilder but is synchronized, making it thread-safe.
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(", World!");
        result = sbf.toString(); // "Hello, World!"

/*
Additional notes:
Internally, a String object stores its characters in a char[] array. Starting with Java 9, this was optimized to a byte array with an encoding flag to save memory.

Best Practices:
Use StringBuilder for Concatenation: For multiple concatenations in a loop or complex operations, use StringBuilder to avoid creating many intermediate String objects.
Use String Pooling: Prefer string literals over new String() to take advantage of the string pool.
Beware of Substrings: Creating substrings can share the underlying character array, which may lead to memory issues if large strings are involved. Java 7+ optimizes this by creating a new character array for substrings.
Use Regular Expressions Judiciously: Regular expressions are powerful but can be complex and slow if not used correctly. Consider alternatives for simple operations.

*/
    }
}