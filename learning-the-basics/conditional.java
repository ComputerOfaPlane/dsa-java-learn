/*
Assign grades based on marks
*/
import java.util.Scanner;

class conditional {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your marks = ");
        int marks = sc.nextInt();
        sc.close();
        char grade;
        marks = marks/10;

        // switch case
        switch(marks){
            case 0:
                grade = 'F';
                break; // if break misses then fall through
            case 5:
                grade = 'E';
                break;
            case 6:
                grade = 'D';
                break;
            case 7:
                grade = 'C';
                break;
            case 8:
                grade = 'B';
                break;
            case 9:
                grade = 'A';
                break;
            case 10:
                grade = 'O';
                break;
            default: grade = 'F';
        }
        System.out.println("Grade = "+grade);

        /* Fall Through
            switch(str){
            case "byte":
            case "boolean":
                size = 1;
                break;
            case "short":
            case "character":
                size = 2;
                break;
            case "integer":
            case "float":
                size = 4;
                break;
            case "long":
            case "double":
                size = 8;
                break;
            default: size = -999;
                break;
        }
        */


        // if else if else
        if(marks<5)
            grade = 'F';
        else if(marks == 10)
            grade = 'O';
        else{
            grade = (char) ( 74 - marks);
        }
        System.out.println("Grade = "+grade);
    }
}