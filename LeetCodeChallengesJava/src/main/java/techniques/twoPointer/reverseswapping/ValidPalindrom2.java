package techniques.twoPointer.reverseswapping;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * https://leetcode.com/problems/valid-palindrome-ii/solutions/209252/java-python-two-pointers-with-thinking-process/
 */
public class ValidPalindrom2 {
    public static void main(String[] args) {
        String s = "aba";
        String s2 = "abca";
        String s3 = "abc";

        System.out.println(validPalindrome(s)); //true
        System.out.println(validPalindrome(s2)); //true
        System.out.println(validPalindrome(s3)); //false

    }

    // Two cases for a valid Palindrom:
    // 1) There is only ONE pair left,right with s.charAt(left) != s.charAt(right)
    //  After removing the left or right the middle should be a palindrom
    // 2) It is actually a palindrom
    private static boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return isPalindrom(s, left+1, right) || isPalindrom(s, left, right-1);
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrom(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
