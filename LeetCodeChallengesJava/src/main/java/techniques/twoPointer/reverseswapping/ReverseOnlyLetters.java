package techniques.twoPointer.reverseswapping;

import java.util.Stack;

/**
 * Given a string s, reverse the string according to the following rules:
 *
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 *
 * https://leetcode.com/problems/reverse-only-letters/editorial/
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s1 = "ab-cd";
        String s2 = "a-bC-dEf-ghIj";
        String s3 = "Test1ng-Leet=code-Q!";

        System.out.println(reverseOnlyLetters(s1)); //dc-ba
        System.out.println(reverseOnlyLetters(s2)); // j-Ih-gfE-dCba
        System.out.println(reverseOnlyLetters(s3)); // Qedo1ct-eeLg=ntse-T!
    }

    private static String reverseOnlyLetters(String s) {
        Stack<Character> letters = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c: chars) {
            if (Character.isLetter(c))
                letters.push(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c: chars) {
            if (Character.isLetter(c))
                result.append(letters.pop());
            else
                result.append(c);
        }
        return result.toString();
    }

//    private static String reverseOnlyLetters(String s) {
//        StringBuilder result = new StringBuilder();
//        int right = s.length()-1;
//        for (int left = 0; left < s.length(); left++) {
//            if (Character.isLetter(s.charAt(left))) {
//                while (!Character.isLetter(s.charAt(right)))
//                    right--;
//                result.append(s.charAt(right--));
//            } else {
//                result.append(s.charAt(left));
//            }
//        }
//        return result.toString();
//    }
}
