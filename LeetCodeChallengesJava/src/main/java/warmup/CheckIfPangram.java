package warmup;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * <p>
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram,
 * or false otherwise.
 */
public class CheckIfPangram {
    public static void main(String[] args) {
        String sentence1 = "thequickbrownfoxjumpsoverthelazydog";
        String sentence2 = "leetcode";

        System.out.println(checkIfPangram(sentence1));
        System.out.println(checkIfPangram(sentence2));
    }

    //    private static boolean checkIfPangram(String sentence) {
//        HashSet<Character> helperSet = new HashSet<>();
//        char[] chars = sentence.toLowerCase().toCharArray();
//        for (char c : chars)
//            helperSet.add(c);
//        return helperSet.size() == 26;
//    }
    private static boolean checkIfPangram(String sentence) {
        for (int i = 0; i < 26; i++) {
            char currentChar = (char) ('a' + i);
            if (sentence.indexOf(currentChar) == -1)
                return false;
        }
        return true;
    }


}
