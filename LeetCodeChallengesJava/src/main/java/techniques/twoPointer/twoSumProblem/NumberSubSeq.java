package techniques.twoPointer.twoSumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is
 * less or equal to target.
 * Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/editorial/
 */
public class NumberSubSeq {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 5, 6, 7};
        int[] nums2 = new int[]{3, 3, 6, 8};
        int[] nums3 = new int[]{2, 3, 3, 4, 6, 7};

        System.out.println(numSubseq(nums1, 9)); //4
        System.out.println(numSubseq(nums2, 10)); //6
        System.out.println(numSubseq(nums3, 12)); //61

        int[] nums4 = new int[]{1,2};
        var subsquences = generateSubsquences(nums4);
        System.out.println(subsquences);
    }

    private static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        List<List<Integer>> subsequences = generateSubsquences(nums);
        int mod = 1_000_000_007;
        for ( List<Integer> sub: subsequences) {
            int min = sub.get(0);
            int max = sub.get(sub.size()-1);
            result += ((max + min) <= target) ? 1 : 0;
            result = result % mod;
        }
        return result;
    }

    private static List<List<Integer>> generateSubsquences(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> subsequences = new ArrayList<>();
        generateSubsequencesHelper(nums, sequence, 0, subsequences);
        return subsequences;
    }

    private static void generateSubsequencesHelper(
            int[] nums, List<Integer> currentSequence,
            int index,
            List<List<Integer>> subsequences
    ) {
        if (index == nums.length) {
            if (!currentSequence.isEmpty())
                subsequences.add(new ArrayList<>(currentSequence));
        } else {

            // 1. Calc all subsequences which contain current element nums[index]
            currentSequence.add(nums[index]);
            generateSubsequencesHelper(nums, currentSequence, index + 1, subsequences);

            // 2. Calc all subsequences which NOT contain current element nums[index]
            currentSequence.remove(currentSequence.size()-1);
            generateSubsequencesHelper(nums, currentSequence, index + 1, subsequences);
        }
    }
}
