package techniques.twoPointer;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still
 * preserving whitespace and initial word order.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/editorial/
 */
public class ReverseWords3 {
    public static void main(String[] args) {
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }

    private static String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                int left = lastSpaceIndex+1;
                int right = i-1;
                chars = reverseWord(chars, left, right);
                lastSpaceIndex = i;
            }
        }
        return new String(chars);
    }

    private static char[] reverseWord(char[] chars, int left, int right) {
        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return chars;
    }
}
