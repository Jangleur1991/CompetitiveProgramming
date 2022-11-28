package stack;

import java.util.Stack;

/**
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParenthesesRecursive(s));
    }



    private static String removeOuterParenthesesRecursive(String s) {
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        return removeHelper(s, counter, stringBuilder);
    }

    private static String removeHelper(String s, int counter, StringBuilder stringBuilder) {
        if (s.length() == 0)
            return stringBuilder.toString();
        char character = s.charAt(0);
        if (character == '(') {
            if (counter>0)
                stringBuilder.append(character);
            counter++;
        } else if (character == ')') {
            if (counter > 1)
                stringBuilder.append(character);
            counter--;
        }
       return removeHelper(s.substring(1), counter, stringBuilder);
    }

    private static String removeOuterParentheses(String s) {
        //Not necessary. It is also possible to use a simple integer as a counter!
        //Stack<Character> stack = new Stack<>();
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //if (stack.size() > 0)
                if (counter > 0)
                    stringBuilder.append(c);
                //stack.push(c);
                counter++;
            } else if (c == ')') {
                //if (stack.size() > 1)
                if (counter > 1)
                    stringBuilder.append(c);
                //stack.pop();
                counter--;
            }
        }
        return stringBuilder.toString();
    }
}
