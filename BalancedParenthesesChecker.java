
import java.util.*; // imported library 
 

// created a class BalancedParenthesesChecker
public class BalancedParenthesesChecker {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // scanner class object name sc

        // Prompt the user to enter an expression
        System.out.print("Enter an expression: "); //  ask user to enter input message  
        String expression = sc.nextLine(); // taking input from user store into expression

        // Check if the expression has balanced parentheses
        if (areParenthesesBalanced(expression)) {
            System.out.println("The expression has balanced parentheses.");
        } else {
            System.out.println("The expression does not have balanced parentheses.");
        }
        sc.close();
    }

    // Method to check if the parentheses in the expression are balanced
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>(); //t stack type is char ype character it only store character value //LIFO last in first out method follow

        // for each read the value of expression
        for (char ch : expression.toCharArray()) { // value change into character abc--> 'a' 'b'  'c' 
            // Push opening parentheses onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Check for closing parentheses
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty or top of stack doesn't match, it's unbalanced
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {// condition to check matching pair of opening and closing paranthesses
                    return false;
                }
            }
        }
        // If stack is empty, parentheses are balanced
        return stack.isEmpty();
    }

    // Method to check if the opening and closing parentheses match
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }

}
