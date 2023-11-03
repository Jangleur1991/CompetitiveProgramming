package techniques.dynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 *
 */
public class CountingBits {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 5;

        System.out.println(Arrays.toString(countBits(n1))); //0,1,1
        System.out.println(Arrays.toString(countBits(n2))); //0,1,1,2,1,2
    }

    private static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            result[i] = countBitsOf(i, result);
        }
        return result;
    }

    private static int countBitsOf(int n, int[] result) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (result[n] != 0) return result[n];

        result[n] = (n%2==0)
                ? countBitsOf(n/2, result)
                : 1+countBitsOf(n/2, result);
        return result[n];
    }
}
