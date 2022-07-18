package stack;

import java.util.Stack;

/**
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 *
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 *
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 *
 * Given a VPS represented as string s, return the nesting depth of s.
 */
public class MaxNestingDepthParentheses {
    public static void main(String[] args) {
        String testString = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(testString));
    }

    private static int maxDepth(String s) {
        //Not necessary. It is also possible to use a simple integer as a counter!
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        //int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(') {
                stack.push(character);
                //counter++;
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (character == ')') {
                stack.pop();
                //counter--;
            }
        }
        return maxDepth;
    }
}
