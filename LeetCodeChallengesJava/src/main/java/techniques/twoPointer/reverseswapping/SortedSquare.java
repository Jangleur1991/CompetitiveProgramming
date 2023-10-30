package techniques.twoPointer.reverseswapping;

import java.util.Arrays;

/**
 *Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
 * sorted in non-decreasing order.
 *
 *
 */
public class SortedSquare {
    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }

    private static int[] sortedSquares(int[] nums) {
        int[] sortedSquaredArray = new int[nums.length];
        int smallerIndex = 0;
        int largerIndex = nums.length-1;

        int i = largerIndex;

        while (smallerIndex <= largerIndex) {
            int smallerValue = nums[smallerIndex];
            int largerValue = nums[largerIndex];

            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                sortedSquaredArray[i] = smallerValue*smallerValue;
                smallerIndex++;
            } else {
                sortedSquaredArray[i] = largerValue*largerValue;
                largerIndex--;
            }
            i--;
        }
        return sortedSquaredArray;
    }
}
