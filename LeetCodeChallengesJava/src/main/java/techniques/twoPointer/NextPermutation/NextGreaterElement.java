package techniques.twoPointer.NextPermutation;

/**
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
 * and is greater in value than n. If no such positive integer exists, return -1.
 *
 * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in
 * 32-bit integer, return -1.
 *
 * https://dev.to/marcelos/leetcode-556-next-greater-element-iii-18lm
 * https://leetcode.com/problems/next-greater-element-iii/solutions/101824/simple-java-solution-4ms-with-explanation/
 * https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int n1 = 12;
        int n2 = 21;
        int n3 = 230241;
        int n4 = 2147483486;
        int n5 = 12222333;

       System.out.println(nextGreaterElement(n1));
       System.out.println(nextGreaterElement(n2));
       System.out.println(nextGreaterElement(n3)); //230412
       System.out.println(nextGreaterElement(n4)); // -1
       System.out.println(nextGreaterElement(n5)); // 12223233
    }

    private static int nextGreaterElement(int n) {
        char[] numbers = String.valueOf(n).toCharArray();

        //Find first number from right where numbers[i-1] < numbers[i]
        int indexOfDigitToSwap = skipUntilDigitLessThanNextDigit(numbers);

        if (indexOfDigitToSwap == -1)
            return -1;

        //Find smallest digit on the right side of indexOfDigitToSwap that is greater
        int smallestDigitOnRightSide = findSmallestIndexOnRightSide(indexOfDigitToSwap, numbers);

        // Swap elements
        swap(numbers, indexOfDigitToSwap, smallestDigitOnRightSide);

        //Reverse elements right of the index to get the smallest greater number
        reverseRightSide(numbers, indexOfDigitToSwap + 1);

        try {
            return Integer.parseInt(new String(numbers));
        } catch ( NumberFormatException e)
        {
            return -1;
        }
    }

    private static int skipUntilDigitLessThanNextDigit(char[] numbers) {
        //Find first number from right where numbers[i-1] < numbers[i]
        for (int i = numbers.length-1; i > 0 ; i--) {
            if (numbers[i-1] < numbers[i])
                return i-1;
        }
        return -1;
    }
    private static int findSmallestIndexOnRightSide(int indexOfDigitToSwap, char[] numbers) {
        int indexOfSmallestDigit = indexOfDigitToSwap+1;
        for (int i = indexOfDigitToSwap+1; i < numbers.length; i++) {
            if (numbers[i] > numbers[indexOfDigitToSwap] && (numbers[i] <= numbers[indexOfSmallestDigit]) )
                indexOfSmallestDigit = i;
        }
        return indexOfSmallestDigit;
    }

    private static void swap(char[] numbers, int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static void reverseRightSide(char[] numbers, int indexOfDigitToSwap) {
        int left = indexOfDigitToSwap, right = numbers.length-1;
        while (left < right) {
            swap(numbers, left++, right--);
        }
    }

}
