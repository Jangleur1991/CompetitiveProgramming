package techniques.twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

/**
 * You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
 *
 * i < j < k,
 * nums[j] - nums[i] == diff, and
 * nums[k] - nums[j] == diff.
 * Return the number of unique arithmetic triplets
 *
 * See here: <a href="https://leetcode.com/problems/number-of-arithmetic-triplets/description/">...</a>
 */
public class ArithmeticTriplets {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 4, 6, 7, 10};
        int[] nums2 = {4, 5, 6, 7, 8, 9};
        System.out.println(arithmeticTripletsRec(nums1, 3));
        System.out.println(arithmeticTripletsRec(nums2, 2));
    }

//    private static int arithmeticTriplets(int[] nums, int diff) {
//        Set<Integer> helpSet = IntStream.of(nums).boxed().collect(toSet());
//        int ans = 0;
//
//        int i = 0;
//        int j = 1;
//        while (i <= j && j < nums.length) {
//            if (nums[j] - nums[i] < diff) {
//                j++;
//            } else if (nums[j] - nums[i] > diff) {
//                i++;
//            } else {
//                if (helpSet.contains(nums[j] + diff))
//                    ans++;
//                i++;
//                j++;
//            }
//        }
//        return ans;
//    }


    private static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> helpSet = IntStream.of(nums).boxed().collect(toSet());
        int ans = 0;
        for (int x : nums) {
            if (helpSet.contains(x - diff) && helpSet.contains(x + diff)) {
                ans++;
            }
        }
        return ans;
    }

    private static int arithmeticTripletsRec(int[] nums, int diff) {
        Set<Integer> helpSet = IntStream.of(nums).boxed().collect(toSet());
        return arithmeticTripletsHelper(nums, diff, 0, helpSet, 0);
    }

    private static int arithmeticTripletsHelper(int[] nums, int diff, int ans, Set<Integer> helpSet, int i) {
        if (i >= nums.length)
            return ans;

        int x = nums[i];
        if (helpSet.contains(x - diff) && helpSet.contains(x + diff)) {
            ans++;
        }
        return arithmeticTripletsHelper(nums, diff, ans, helpSet, i+1);
    }
}