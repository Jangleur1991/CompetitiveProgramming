package techniques.twoPointer;

/**
 * You are given a string s consisting of lowercase English letters, and you are allowed to perform operations on it.
 * In one operation, you can replace a character in s with another lowercase English letter.
 *
 * Your task is to make s a palindrome with the minimum number of operations possible.
 * If there are multiple palindromes that can be made using the minimum number of operations,
 * make the lexicographically smallest one.
 *
 *
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a
 * and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
 *
 * Return the resulting palindrome string.
 */
public class MakeSmallestPalindrom {
    public static void main(String[] args) {
        String s1 = "egcfe";
        String s2 = "abcd";
        String s3 = "seven";

        System.out.println(makeSmallestPalindrome(s1)); //"efcfe"
        System.out.println(makeSmallestPalindrome(s2)); // abba
        System.out.println(makeSmallestPalindrome(s3)); // neven

    }

    private static String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n/2; i++) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(n - i -1);
            if (c1 < c2) {
                sb.setCharAt(n - i -1, c1);
            } else {
                sb.setCharAt(i, c2);
            }
        }
        return sb.toString();
    }
}
