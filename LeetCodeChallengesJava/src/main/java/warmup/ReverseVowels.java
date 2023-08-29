package warmup;

import java.util.stream.Stream;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "leetcode";
        System.out.println(reverseVowels2(s1));
        System.out.println(reverseVowels2(s2));
    }
    private static String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < s.length() -1 && !isVowel(chars[left]))
                left++;
            while(right >= 0 && !isVowel(chars[right]))
                right--;
            if (left < right)
                swap(chars, left++, right--);
        }
        return new String(chars);
    }

    private static String reverseVowels2(String s) {
        return reverseVowelsHelper(s.toCharArray(), 0, s.length()-1);
    }

    private static String reverseVowelsHelper(char[] chars, int left, int right) {
        if (left >= right)
            return new String(chars);

        if (!isVowel(chars[left]))
            return reverseVowelsHelper(chars, left+1, right);

        if (!isVowel(chars[right]))
            return reverseVowelsHelper(chars, left, right-1);

        swap(chars, left, right);
        return reverseVowelsHelper(chars, left+1, right-1);
    }

    private static boolean isVowel(char character) {
        return Stream.of('a', 'i', 'e', 'o', 'u')
                .anyMatch(c -> c == Character.toLowerCase(character));
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
