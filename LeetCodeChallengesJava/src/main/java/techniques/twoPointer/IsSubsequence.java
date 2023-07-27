package techniques.twoPointer;

/**
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not)
 *
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";

        String s2 = "";
        String t2 = "ahbgdc";

        System.out.println(isSubsequence(s1, t1));
        System.out.println(isSubsequence(s2, t2));
    }

//    private static boolean isSubsequence(String s, String t) {
//        int sIndex = 0;
//        int tIndex = 0;
//
//        while (tIndex < t.length() && sIndex < s.length()) {
//            if (t.charAt(tIndex) == s.charAt(sIndex))
//                sIndex++;
//            tIndex++;
//        }
//
//        return sIndex == s.length();
//    }

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        int sIndex = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(sIndex))
                sIndex++;
            if (sIndex == s.length())
                return true;
        }
        return false;
    }
}
