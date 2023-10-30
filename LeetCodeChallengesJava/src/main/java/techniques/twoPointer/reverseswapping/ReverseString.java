package techniques.twoPointer.reverseswapping;

import java.util.Arrays;

/**
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H','a','n','n','a','h'};

        reverseString(s1);
        reverseString(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }

    private static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseString2(char[] s) {
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
    }
}
