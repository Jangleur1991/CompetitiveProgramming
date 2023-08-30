package warmup;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 */
public class IsAnagram {
    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        System.out.println(isAnagramRec(s1, t1));
        System.out.println(isAnagramRec(s2, t2));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        boolean isAnagram = true;
        for (int i = 0; i < tchars.length; i++) {
            isAnagram = isAnagram && schars[i] == tchars[i];
        }
        return isAnagram;
    }

    private static boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0)
                return false;
        }
        return true;
    }

    private static boolean isAnagramRec(String s, String t) {
        if (s.length() != t.length())
            return false;
        return isAnagramHelper(s, t, 0);
    }

    private static boolean isAnagramHelper(String s, String t, int i) {
        if (i == s.length())
            return true;

        char currentChar = s.charAt(i);
        int numberOfCurrentCharInS = countOccurrences(s.toCharArray(), currentChar, 0, 0);
        int numberOfCurrentCharInT = countOccurrences(t.toCharArray(), currentChar, 0, 0);

        if ( numberOfCurrentCharInS != numberOfCurrentCharInT )
            return false;

        return isAnagramHelper(s, t, i+1);
    }

    private static int countOccurrences(char[] chars, char currentChar, int i, int result) {
        if (i == chars.length)
            return result;

        return countOccurrences(chars, currentChar, i+1, chars[i] == currentChar ? result+1 : result);
    }
}
