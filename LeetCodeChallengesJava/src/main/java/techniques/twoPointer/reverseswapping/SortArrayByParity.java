package techniques.twoPointer.reverseswapping;

import java.util.Arrays;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        int[] nums2 = new int[]{0};

        System.out.println(Arrays.toString(sortArrayByParity(nums))); //2,4,3,1
        System.out.println(Arrays.toString(sortArrayByParity(nums2))); //0
    }

    private static int[] sortArrayByParity(int[] nums) {
        int positionOfLastOddNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[positionOfLastOddNumber];
                nums[positionOfLastOddNumber] = temp;
                positionOfLastOddNumber++;
            }
        }
        return nums;
    }
}
