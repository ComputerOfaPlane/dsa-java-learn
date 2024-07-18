import java.util.Stack;

class LearnStack {

    public static void main(String[] args) {
        
        Stack<String> burger = new Stack<>();

        // adding elements
        burger.push("bottom bun"); // O(1)
        burger.push("mayonaise");
        burger.push("lettuce");
        burger.push("ketchup");
        burger.push("patty");
        burger.push("veggies");
        burger.push("oregano");
        burger.push("cheese");
        burger.push("sauce");
        burger.push("top bun");

        System.out.println(burger); // print line internally call .toString ()

        // see the top element
        System.out.println( burger.peek() ); // O(1)

        // remove
        System.out.println( burger.pop() ); // O(1)

        System.out.println(burger);

        burger.clear();

        System.out.println(burger);


    }
}