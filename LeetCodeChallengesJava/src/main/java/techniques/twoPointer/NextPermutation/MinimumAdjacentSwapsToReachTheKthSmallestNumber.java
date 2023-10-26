package techniques.twoPointer.NextPermutation;

/**
 *
 * You are given a string num, representing a large integer, and an integer k.
 *
 * We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num.
 * There can be many wonderful integers. However, we only care about the smallest-valued ones.
 *
 * For example, when num = "5489355142":
 * The 1st smallest wonderful integer is "5489355214".
 * The 2nd smallest wonderful integer is "5489355241".
 * The 3rd smallest wonderful integer is "5489355412".
 * The 4th smallest wonderful integer is "5489355421".
 *
 * Return the minimum number of adjacent digit swaps that needs to be applied to num to reach the kth
 * smallest wonderful integer.
 *
 * The tests are generated in such a way that kth smallest wonderful integer exists.
 *
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
 */
public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {
    public static void main(String[] args) {
        String num1 = "5489355142";
        String num2 = "11112";
        String num3 = "00123";

        int k1 = 4;
        int k2 = 4;
        int k3 = 1;

        System.out.println(getMinSwaps(num1, k1));
        System.out.println(getMinSwaps(num2, k2));
        System.out.println(getMinSwaps(num3, k3));

    }

    private static int getMinSwaps(String num, int k) {
        return 0;
    }
}
