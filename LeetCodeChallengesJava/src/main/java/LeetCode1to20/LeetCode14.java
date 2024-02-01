package LeetCode1to20;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LeetCode14 {
    public static void main(String[] args) {
        String[] strs1 = new String[]{"flower", "flow", "flight"};
        String[] strs2 = new String[]{"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }

    // s:= length of the longest String
    // a:= length or array
//    private static String longestCommonPrefix(String[] strs) {
//        StringBuilder sb = new StringBuilder();
//        for (char c : strs[0].toCharArray()) { //s times
//            boolean isCommonPrex = true;
//            for (int i = 1; i < strs.length; i++) { // a-1 times
//                isCommonPrex = isCommonPrex && strs[i].contains(String.valueOf(c)); //s times
//            }
//            if (isCommonPrex)
//                sb.append(c);
//            else
//                break;
//        }
//        return sb.toString();
//    } // a*s^2

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length-1];
        int lengthOfSmaller = Math.min(first.length(), last.length());
        for (int i = 0; i < lengthOfSmaller; i++) {
            if (first.charAt(i) != last.charAt(i))
                return sb.toString();
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}
