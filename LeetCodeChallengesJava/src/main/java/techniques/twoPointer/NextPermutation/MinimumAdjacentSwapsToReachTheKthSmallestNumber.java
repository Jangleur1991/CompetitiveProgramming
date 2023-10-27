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

        System.out.println(getMinSwaps(num1, k1)); //2
        System.out.println(getMinSwaps(num2, k2)); //4
        System.out.println(getMinSwaps(num3, k3)); //1

    }

    private static int getMinSwaps(String num, int k) {
        char[] digits = num.toCharArray();
        //Find k-th permutation
        char[] kthPermutation = kthPermutation(num.toCharArray(), k);
        //Find minimal adjacent swaps between digits and kthPermutation
        return minimalAdjacentSwaps(digits, kthPermutation);
    }

    private static char[] kthPermutation(char[] digits, int k) {
        while (k>0) {
            digits = nextPermutation(digits, k);
            k--;
        }
        return digits;
    }

    private static int minimalAdjacentSwaps(char[] digits, char[] kthPermutation) {
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != kthPermutation[i]) {
                int j = i+1;
                while (digits[i] != kthPermutation[j])
                    j++; //Find index to swap
                while (j != i) {
                    char temp = kthPermutation[j];
                    kthPermutation[j] = kthPermutation[j-1];
                    kthPermutation[j-1] = temp;
                    // Swap until the characters
                    // are at same index
                    j--;
                    result++;
                }
            }
        }
        return result;
    }

    private static char[] nextPermutation(char[] nums, int k) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;
        if (i >= 0) {
            int j = nums.length-1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
        return nums;
    }


    private static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(char[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
