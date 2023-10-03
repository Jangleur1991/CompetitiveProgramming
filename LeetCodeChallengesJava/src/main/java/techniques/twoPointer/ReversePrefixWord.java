package techniques.twoPointer;

/**
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the
 * index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
 *
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3
 * (inclusive). The resulting string will be "dcbaefd".
 *
 * Return the resulting string.
 */
public class ReversePrefixWord {
    public static void main(String[] args) {
        String word1 = "abcdefd";
        String word2 = "xyxzxe";
        String word3 = "abcd";

        System.out.println(reversePrefix(word1, 'd')); //dcbaefd
        System.out.println(reversePrefix(word2, 'z')); //xyxzxe
        System.out.println(reversePrefix(word3, 'z')); //abcd
    }

    private static String reversePrefix(String word, char ch) {
        int indexOfCh = word.indexOf(ch);
        if (indexOfCh == -1)
            return word;

        StringBuilder result = new StringBuilder(word);
        for (int i = 0; i < (indexOfCh+1)/2; i++) {
            result.setCharAt(i, word.charAt(indexOfCh-i));
            result.setCharAt(indexOfCh-i, word.charAt(i));
        }
        return result.toString();
    }
}
