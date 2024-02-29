package LeetCode1to20;

import java.util.HashMap;
import java.util.Map;

public class LeetCode383 {
    public static void main(String[] args) {
        String ransomNote1 = "a";
        String magazine1  = "b";

        String ransomNote2 = "aa";
        String magazine2  = "ab";

        String ransomNote3 = "aa";
        String magazine3  = "aab";

        System.out.println(canConstruct(ransomNote1, magazine1));//false
        System.out.println(canConstruct(ransomNote2, magazine2));//false
        System.out.println(canConstruct(ransomNote3, magazine3));//true
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineLetter = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char currentLetter = magazine.charAt(i);
            int countCurrentLetter = magazineLetter.getOrDefault(currentLetter, 0);
            magazineLetter.put(currentLetter, countCurrentLetter+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ransomNoteLetter = ransomNote.charAt(i);

            int countCurrentLetter = magazineLetter.getOrDefault(ransomNoteLetter, 0);

            if (0 == countCurrentLetter)
                return false;

            magazineLetter.put(ransomNoteLetter, countCurrentLetter-1);
        }
        return true;
    }
}
