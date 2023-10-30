package techniques.twoPointer.reverseswapping;

import sorting.QuickSort;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * https://iq.opengenus.org/three-way-partitioning/
 * https://coderbyte.com/algorithm/dutch-national-flag-sorting-problem
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] nums2 = {1,2,0};
        sortColors(nums);
        sortColors(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

    private static void sortColors(int[] nums) {
        sortColorsHelper(nums);
    }

    private static void sortColorsHelper(int[] nums) {
        int n = nums.length;

        int i = 0, begin = 0, end = n-1;

        while(i <= end)
        {
            if (nums[i] == 0) {
                QuickSort.swap(nums, i, begin);
                i++;
                begin++;
            } else if (nums[i] == 2) {
                QuickSort.swap(nums, i, end);
                end--;
            } else {
                i++;
            }
        }
    }
}
