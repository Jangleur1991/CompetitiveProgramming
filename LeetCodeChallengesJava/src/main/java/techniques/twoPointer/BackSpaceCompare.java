package techniques.twoPointer;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackSpaceCompare {
    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";

        String s2 = "ab##";
        String t2 = "c#d#";

        String s3 = "a#c";
        String t3 = "b";

        String s4 = "xywrrmp";
        String t4 = "xywrrmu#p";

        String s5 = "bxj##tw";
        String t5 = "bxj###tw";

        System.out.println(backspaceCompareTwoPointer(s1, t1));
        System.out.println(backspaceCompareTwoPointer(s2, t2));
        System.out.println(backspaceCompareTwoPointer(s3, t3));
        System.out.println(backspaceCompareTwoPointer(s4, t4));
        System.out.println(backspaceCompareTwoPointer(s5, t5));
    }


    private static boolean backspaceCompareTwoPointer(String s, String t) {
        int skips = 0, skipt = 0;
        int sIndex = s.length()-1, tIndex = t.length()-1;

        while (sIndex >= 0 || tIndex >= 0) {
            sIndex = findIndexOfNextChar(s, sIndex, skips);
            tIndex = findIndexOfNextChar(t, tIndex, skipt);

            if (sIndex >= 0 && tIndex >= 0 && s.charAt(sIndex) != t.charAt(tIndex))
                return false;

            if ((sIndex >= 0) != (tIndex >= 0))
                return false;

            sIndex--;
            tIndex--;
        }
        return true;
    }

    private static int findIndexOfNextChar(String s, int index, int skip) {
        while (index >= 0 && (s.charAt(index) == '#' || skip > 0)) {
            skip = s.charAt(index) == '#' ? skip+1 : skip-1;
            index--;
        }
        return index;
    }

    private static boolean backspaceCompareStack(String s, String t) {
        String s2 = removeBackspaces(s);
        String t2 = removeBackspaces(t);
        return s2.equals(t2);
    }

    private static String removeBackspaces(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> result = new Stack<>();
        for (char c: chars) {
            if (c != '#') {
                result.push(c);
            } else if (!result.empty()) {
                result.pop();
            }
       }
        return String.valueOf(result);
    }
}
