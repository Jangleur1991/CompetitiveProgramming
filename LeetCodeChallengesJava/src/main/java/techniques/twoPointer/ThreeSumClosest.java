package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-1,2,1,-4};
        int target1 = 1;
        int[] nums2 = new int[]{0,0,0};
        int target2 = 1;

        System.out.println(threeSumClosest(nums1, target1));
        System.out.println(threeSumClosest(nums2, target2));

    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            result = threeSumClosestHelper(nums, i, target, result);
        }

        return result;
    }

    private static int threeSumClosestHelper(int[] nums, int i, int target, int result) {
        int left = i + 1;
        int right = nums.length-1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum <= target) {
                left++;
            } else {
                right--;
            }
            if (Math.abs(target-sum) < Math.abs(target-result))
                result = sum;
        }
        return result;
    }
}
