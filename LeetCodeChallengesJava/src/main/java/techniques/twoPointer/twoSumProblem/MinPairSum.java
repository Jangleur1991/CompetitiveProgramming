package techniques.twoPointer.twoSumProblem;

import java.util.Arrays;

/**
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
 * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
 * Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
 *
 * Each element of nums is in exactly one pair, and
 * The maximum pair sum is minimized.
 *
 * Return the minimized maximum pair sum after optimally pairing up the elements.
 *
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/editorial/
 */
public class MinPairSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,5,2,3};
        int[] nums2 = new int[]{3,5,4,2,4,6};

        System.out.println(minPairSum(nums1)); //7
        System.out.println(minPairSum(nums2)); //8
    }

    private static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int result = 0;
        for (int i = 0; i < n/2; i++) {
            result = Math.max(result, nums[i] + nums[n-1-i]);
        }
        return result;
    }
}
