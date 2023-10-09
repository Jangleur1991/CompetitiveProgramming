package techniques.twoPointer;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other, append the additional letters onto the end of
 * the merged string.
 *
 * Return the merged string.
 */
public class MergeAlternately {
    public static void main(String[] args) {
        String word11 = "abc";
        String word21 = "pqr";

        String word12 = "ab";
        String word22 = "pqrs";

        String word13 = "abcd";
        String word23 = "pq";

        System.out.println(mergeAlternately(word11, word21)); //a p b q c r
        System.out.println(mergeAlternately(word12, word22)); //a p b q   r   s
        System.out.println(mergeAlternately(word13, word23)); //a p b q c   d

    }

//    private static String mergeAlternately(String word1, String word2) {
//        int lengthWord1 = word1.length();
//        int lengthWord2 = word2.length();
//        StringBuilder result = new StringBuilder();
//
//        int firstPointer = 0, secondPointer = 0;
//
//        while (firstPointer < lengthWord1 || secondPointer < lengthWord2) {
//            if (firstPointer < lengthWord1)
//                result.append(word1.charAt(firstPointer++));
//            if (secondPointer < lengthWord2)
//                result.append(word2.charAt(secondPointer++));
//        }
//        return result.toString();
//    }

    private static String mergeAlternately(String word1, String word2) {
        int lengthWord1 = word1.length();
        int lengthWord2 = word2.length();
        int resultLength = Math.max(lengthWord1, lengthWord2);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < resultLength; i++) {
            if (i < lengthWord1)
                result.append(word1.charAt(i));
            if (i < lengthWord2)
                result.append(word2.charAt(i));
        }
        return result.toString();
    }
}
