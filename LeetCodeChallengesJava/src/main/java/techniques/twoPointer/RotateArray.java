package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * https://leetcode.com/problems/rotate-array/solutions/54250/easy-to-read-java-solution/
 * https://leetcode.com/problems/rotate-array/solutions/1730142/java-c-python-a-very-very-well-detailed-explanation/
 *
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        int[] nums2 = new int[]{-1,-100,3,99};

        rotate(nums1, 3);
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums1)); //[5,6,7,1,2,3,4]
        System.out.println(Arrays.toString(nums2)); //[3,99,-1,-100]
    }

    private static void rotate(int[] nums, int k) {
        k %= nums.length;

        //reverse part1
        reverseArray(nums, 0, nums.length-k-1);

        //reverse part2
        reverseArray(nums, nums.length-k, nums.length-1);

        // reverse complete
        reverseArray(nums, 0, nums.length-1);
    }

    private static void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
