class loops {
    public static void main(String[] args) {
        
        // loops =: entry controlled (for and while) and exit controlled(do while)

        // while loop
        int i = 1; // initialization
        while (i<10) { // condition
            /*
                ....
                code
                ....
            */
            i++; // loop control variable updation
        }
        
        // for loop
        /*
            1. the loop control variable is initialized
            2. the condition is checked
            3. the code block is executed
            4. updation of loop control variable
            5. repeat step 2-4

        */
        for (int k=1; k<=10 ;k++ ) {
            /*
                ....
                code
                ....
            */
        }
        for (char alphabets='A';alphabets<='Z' ;alphabets++ ) {
            System.out.println(alphabets);
        } // prints all alphabets A-Z

        // looping over iterable objects like arrays or java.lang.Iterable
        int arr[] = {1,2,3,4,5,6,7};
        for(int num: arr){
            System.out.println(num);
        }
        String a= "aniket";
        for(char c:a.toCharArray()){
            System.out.println(c);
        }

        // do while loop
        int j = 10; // intialization
        do {
            /*
                ....
                code
                ....
            */
            System.out.println(j--); // updation
        }while(j>0); // condition
        /*
            1. the loop control variable is initialized
            3. the code block is executed
            4. updation of loop control variable
            2. the condition is checked
            5. repeat step 2-4

        */

        // break statement takes the control flow out of the loop
        // continue skips succeeding code statements
        // goto is a keyword but isn't implemented, it can be acheived by labeling



    }
}