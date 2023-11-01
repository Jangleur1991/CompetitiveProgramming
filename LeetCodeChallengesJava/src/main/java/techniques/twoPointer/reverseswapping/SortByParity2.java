package techniques.twoPointer.reverseswapping;

import java.util.Arrays;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 */
public class SortByParity2 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,7};
        int[] nums2 = new int[]{2,3};

        System.out.println(Arrays.toString(sortArrayByParityII(nums))); //4,5,2,7
        System.out.println(Arrays.toString(sortArrayByParityII(nums2))); //2,3
    }

    private static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int evenIndex = 0, oddIndex = 1;
        while (evenIndex < n && oddIndex < n ) {
            if (nums[evenIndex] % 2 == 0)
                evenIndex += 2;
            else if (nums[oddIndex] % 2 == 1)
                oddIndex +=2;
            else
                swap(nums, evenIndex, oddIndex);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
