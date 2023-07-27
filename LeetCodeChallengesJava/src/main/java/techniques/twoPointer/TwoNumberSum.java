package techniques.twoPointer;

import java.util.*;

/**
 * Given an array of distinct integers and an integer representing the target sum, we are asked to implement a
 * function that is going to find out whether there's a pair of numbers in the array that adds up to the target sum.
 * If such pair exists, return the pair in any order; otherwise return an empty array. We cannot add a number to itself
 * to get the target sum.
 *
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 7};
        System.out.println(Arrays.toString(twoNumberSumWithTwoPointer(nums, 10)));
    }

    private static int[] twoNumberSum(int[] nums, int targetSum) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == targetSum)
                    return new int[]{nums[i], nums[j]};
            }
        }
        return new int[]{};
    }

    private static int[] twoNumberSumWithMap(int[] nums, int targetSum) {
        Map<Integer, Integer> helperMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            helperMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = targetSum-nums[i];

            if (helperMap.containsKey(complement) && helperMap.get(complement) != i) {
                return new int[]{nums[i], complement};
            }
        }
        return new int[]{};
    }

    private static int[] twoNumberSumWithSet(int[] nums, int targetSum) {
        Set<Integer> helperSet = new HashSet<>();
        for (int num : nums) {
            int complement = targetSum - num;
            if (helperSet.contains(complement)) {
                return new int[]{num, complement};
            }
            helperSet.add(num);
        }
        return new int[]{};
    }

    private static int[] twoNumberSumWithTwoPointer(int[] nums, int targetSum) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int currentSum = nums[left] + nums[right];

            if (currentSum == targetSum)
                return new int[]{nums[left], nums[right]};

            if (currentSum < targetSum) {
                left++;
            } else {
                right++;
            }
        }
        return new int[]{};
    }
}
