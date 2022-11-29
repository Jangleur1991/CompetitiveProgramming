package arrays;

import java.util.Collections;
import java.util.Stack;

/**
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 */
public class FinalValueAfterOperations {
    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperationsRec(operations));
    }

    private static int finalValueAfterOperationsRec(String[] operations) {
        return calcResult(stringToStack(operations), 0);
    }

    private static Stack<String> stringToStack(String[] operations) {
        Stack<String> operationsStack = new Stack<>();
        Collections.addAll(operationsStack, operations);
        return operationsStack;
    }

    private static int calcResult(Stack<String> operations, int result) {
        if (operations.size() == 0)
            return result;

        String operation = operations.pop();
        result += operation.charAt(1) == '+'
                ? 1
                : -1;
        return calcResult(operations, result);
    }

    private static int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            //Only the char at the index 1 is important!
            result += operation.charAt(1) == '+'
                    ? 1
                    : -1;
        }
        return result;
    }
}
