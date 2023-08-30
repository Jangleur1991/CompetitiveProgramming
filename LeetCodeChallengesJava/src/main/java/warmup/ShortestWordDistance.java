package warmup;

/**
 * Given a list of words and two wordsword1_and_word2, return the shortest distance between these two words in the list.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word11 = "coding", word12 = "practice";
        String word21 = "makes", word22 = "coding";

        System.out.println(shortestDistance(words, word11, word12)); //3
        System.out.println(shortestDistance(words, word21, word22)); //1
    }

    private static int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            }
            if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                shortest = Math.min(Math.abs(i1 - i2), shortest);
            }
        }
        return shortest;
    }
}
