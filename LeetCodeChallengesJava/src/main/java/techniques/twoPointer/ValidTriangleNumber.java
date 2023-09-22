package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we
 * take them as side lengths of a triangle.
 *
 * https://leetcode.com/problems/valid-triangle-number/editorial/
 */
public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,3,4};
        int[] nums2 = new int[]{4,2,3,4};
        int[] nums3 = new int[]{7,0,0,0};

//        System.out.println(triangleNumber(nums1)); //3
//        System.out.println(triangleNumber(nums2)); //4
        System.out.println(triangleNumber(nums3)); //0
    }

    private static int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int thirdSideIndex = i+2;
            for (int j = i+1; j < nums.length-1; j++) {
                thirdSideIndex = binarySearch(nums, thirdSideIndex, nums.length-1, nums[i] + nums[j]);
                result += Math.max(thirdSideIndex - j -1, 0);
            }
        }
        return result;
    }

    private static int binarySearch(int[] nums, int left, int right, int sum) {
        if (left > right || right == nums.length)
            return left;
        int midIndex = (left + right) / 2;
        return (nums[midIndex] >= sum)
                ? binarySearch(nums, left, midIndex - 1, sum)
                : binarySearch(nums, midIndex + 1, right, sum);
    }
}
