package LeetCode1to20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String s1= "()";
        String s2= "()[]{}";
        String s3= "(]";
        String s4= "(({()}[]))";
        String s5= "]";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    private static boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) { //use charAt instead with a normal loop???
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(stack.pop()) != c) //check if stack is empty!!!
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
