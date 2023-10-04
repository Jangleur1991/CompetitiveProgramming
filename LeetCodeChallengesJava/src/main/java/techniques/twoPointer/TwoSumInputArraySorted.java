package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
 * that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 < numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
 * of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSumInputArraySorted {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,15};
        int[] nums2 = new int[]{2,3,4};
        int[] nums3 = new int[]{-1,0};

        System.out.println(Arrays.toString(twoSum(nums1, 9))); //[1,2]
        System.out.println(Arrays.toString(twoSum(nums2, 6))); //[1,3]
        System.out.println(Arrays.toString(twoSum(nums3, -1))); //[1,2]


    }

    private static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (nums[left]+nums[right] != target) {
            if (nums[left]+nums[right] < target) left++;
            else right--;
        }
        return new int[]{left+1, right+1};
    }

}
