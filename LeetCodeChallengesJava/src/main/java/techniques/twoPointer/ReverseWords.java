package techniques.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";
        String s4 = "a   e";



         System.out.println(reverseWords2(s1));
        System.out.println(reverseWords2(s2));
        System.out.println(reverseWords2(s3));
        System.out.println(reverseWords2(s4));
    }


    private static String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        reverseArray(chars, 0, chars.length-1);
        reverseWords(chars);
        return cleanOutSpaces(chars);
    }

    private static void reverseArray(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseWords(char[] chars) {
        int left = 0;
        int right;
        while (left < chars.length) {
            while (left < chars.length && chars[left] == ' ' )
                left++;
            right = left;
            while (right < chars.length && chars[right] != ' ')
                right++;
            reverseArray(chars, left, right-1);
            left = right;
        }
    }

    private static String cleanOutSpaces(char[] chars) {
        int left = 0;
        int right = 0;

        while (right < chars.length) {
            while (right < chars.length && chars[right] == ' ')
                right++;
            while (right < chars.length && chars[right] != ' ') {
                chars[left] = chars[right];
                left++;
                right++;
            }
            while (right < chars.length && chars[right] == ' ') {
                right++;
            }
            if ( right < chars.length) {
                chars[left] = ' ';
                left++;
            }
        }
        return new String(chars).substring(0, left);
    }

    private static String reverseWords(String s) {
        String reverseString = reverseString(s);

        List<String> listOfWords =
                stringToList(reverseString).stream()
                .map(ReverseWords::reverseWord).collect(Collectors.toList());

        return String.join(" ", listOfWords);
    }

    private static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private static String reverseWord(String word) {
        char[] characters = word.toCharArray();
        int left = 0;
        int right = characters.length-1;
        while (left<right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            left++;
            right--;
        }
        return new String(characters);
    }

    private static ArrayList<String> stringToList(String s) {
        return new ArrayList<>(Arrays.asList(s.trim().split("\\W+")));
    }
}
