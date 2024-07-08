// for scanner class
import java.util.Scanner;

// for input thrpugh buffered reader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class input_output {
	public static void main(String[] args) throws IOException {
		
		// data types all
		int a;
		double b; // double precision floating point number
		char c; 
		String s;
		long d; // 64 bit integer
		float f; // floating point number
		boolean g; // True or False
		byte h; // 8 bit integer
		short i; // 16 bit integer


		// Scanner
        Scanner scanner = new Scanner(System.in);

 		// Reading an integer
        System.out.println("Enter an integer:");
        int intValue = scanner.nextInt();

        // Reading a float
        System.out.println("Enter a float:");
        float floatValue = scanner.nextFloat();

        // Reading a double
        System.out.println("Enter a double:");
        double doubleValue = scanner.nextDouble();

        // Reading a character
        System.out.println("Enter a character:");
        char charValue = scanner.next().charAt(0);

        // Reading a boolean
        System.out.println("Enter a boolean:");
        boolean booleanValue = scanner.nextBoolean();

        // Reading a byte
        System.out.println("Enter a byte:");
        byte byteValue = scanner.nextByte();

        // Reading a short
        System.out.println("Enter a short:");
        short shortValue = scanner.nextShort();

        // Reading a long
        System.out.println("Enter a long:");
        long longValue = scanner.nextLong();

        // Reading a string
        scanner.nextLine(); // Consume the leftover newline
        System.out.println("Enter a string:");
        String stringValue = scanner.nextLine();

        scanner.close();

        // Printing the values
        System.out.println("Integer: " + intValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Character: " + charValue);
        System.out.println("Boolean: " + booleanValue);
        System.out.println("Byte: " + byteValue);
        System.out.println("Short: " + shortValue);
        System.out.println("Long: " + longValue);
        System.out.println("String: " + stringValue);

        // buffered reader for complex inputs
        /*
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading an integer
        System.out.println("Enter an integer:");
        intValue = Integer.parseInt(reader.readLine());

        // Reading a float
        System.out.println("Enter a float:");
        floatValue = Float.parseFloat(reader.readLine());

        // Reading a double
        System.out.println("Enter a double:");
        doubleValue = Double.parseDouble(reader.readLine());

        // Reading a character
        System.out.println("Enter a character:");
        charValue = reader.readLine().charAt(0);

        // Reading a boolean
        System.out.println("Enter a boolean:");
        booleanValue = Boolean.parseBoolean(reader.readLine());

        // Reading a byte
        System.out.println("Enter a byte:");
        byteValue = Byte.parseByte(reader.readLine());

        // Reading a short
        System.out.println("Enter a short:");
        shortValue = Short.parseShort(reader.readLine());

        // Reading a long
        System.out.println("Enter a long:");
        longValue = Long.parseLong(reader.readLine());

        // Reading a string
        System.out.println("Enter a string:");
        stringValue = reader.readLine();

        // Printing the values
        System.out.println("Integer: " + intValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Double: " + doubleValue);
        System.out.println("Character: " + charValue);
        System.out.println("Boolean: " + booleanValue);
        System.out.println("Byte: " + byteValue);
        System.out.println("Short: " + shortValue);
        System.out.println("Long: " + longValue);
        System.out.println("String: " + stringValue);
	}
}