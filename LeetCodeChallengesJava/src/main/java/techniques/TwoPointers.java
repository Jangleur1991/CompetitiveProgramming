package techniques;

import java.util.Arrays;

/**
 * Examples for the two pointers technique.
 *
 */
public class TwoPointers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int sum = 5;
        System.out.println(existsPairWithGivenSumForSortedArray(nums, sum));
        System.out.println(Arrays.toString(reverseArray(nums)));
    }


    // Naive implementation
    /*private static boolean existsPairWithGivenSumForSortedArray(int[] nums, int sum) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i] + nums[j] == sum)
                    return true;
            }
        }
        return false;
    }*/

    // Two Pointer Implementation
    // The array nums must be sorted!
    private static boolean existsPairWithGivenSumForSortedArray(int[] nums, int sum) {
        int i = 0;
        int j = nums.length-1;

        while (i < j) {
            int tempSum = nums[i] + nums[j];
            if (tempSum == sum)
                return true;
            if (sum > tempSum)
                i++;
            if (sum < tempSum)
                j--;
        }
        return false;
    }

    // Naive implementation
    /*private static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[n-1-i] = nums[i];
        }
        return ans;
    }*/

    // Two Pointer Implementation
    private static int[] reverseArray(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        while (i < j) {

            //Swap elements
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
        return nums;
    }

}
