package techniques;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * See: <a href="https://leetcode.com/problems/valid-palindrome/description/">...</a>
 */
public class ValidPalindorm {
    public static void main(String[] args) {
        String text = "race a car";
        System.out.println(isPalindromRec(text));
    }

    private static boolean isPalindrom(String text) {
        if (null == text) return false;

        if (text.length() == 1) return true;

        int left = 0;
        int right = text.length()-1;

        while (left < right) {
            char leftChar = Character.toLowerCase(text.charAt(left));
            char rightChar = Character.toLowerCase(text.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isPalindromRec(String text) {
        if (null == text) return false;
        return isPalindromHelper(text, 0, text.length()-1);
    }

    private static boolean isPalindromHelper(String text, int left, int right) {
        if (left >= right)
            return true;

        char leftChar = Character.toLowerCase(text.charAt(left));
        char rightChar = Character.toLowerCase(text.charAt(right));

        if (!Character.isLetterOrDigit(leftChar)) {
            return isPalindromHelper(text, left + 1, right);
        } else if (!Character.isLetterOrDigit(rightChar)) {
            return isPalindromHelper(text, left, right - 1);
        } else if (leftChar != rightChar) {
            return false;
        } else {
            return isPalindromHelper(text, left + 1, right - 1);
        }
    }
}
