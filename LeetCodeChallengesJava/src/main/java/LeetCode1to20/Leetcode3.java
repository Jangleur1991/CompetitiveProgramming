package LeetCode1to20;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Leetcode3 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "dvdf";
        String s5 = "advvdabeab";
        String s6 = "a";

        System.out.println(lengthOfLongestSubstring(s1)); //3
        System.out.println(lengthOfLongestSubstring(s2)); //1
        System.out.println(lengthOfLongestSubstring(s3)); //3
        System.out.println(lengthOfLongestSubstring(s4)); //3
        System.out.println(lengthOfLongestSubstring(s5)); //5
        System.out.println(lengthOfLongestSubstring(s6)); //1
    }

//    private static int lengthOfLongestSubstring(String s) {
//        int result = 0, currentLength = 0, indexOfLastRepeat = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (map.containsKey(c) && map.get(c) >= indexOfLastRepeat) {
//                indexOfLastRepeat = map.get(c);
//                currentLength = i - indexOfLastRepeat - 1;
//                map.put(c, i);
//            }
//            map.put(c, i);
//            currentLength++;
//            result = Math.max(result, currentLength);
//        }
//        return result;
//    }

    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (map.containsKey(s.charAt(windowEnd))) {
                windowStart = Math.max(windowStart, map.get(s.charAt(windowEnd))+1);
            }
            map.put(s.charAt(windowEnd), windowEnd);
            result = Math.max(result, windowEnd-windowStart+1);
        }
        return result;
    }
}
