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
        System.out.println(existsPairWithGivenSumForSortedArrayRec(nums, sum));
        System.out.println(Arrays.toString(reverseArrayRec(nums)));
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

    private static boolean existsPairWithGivenSumForSortedArrayRec(int[] nums, int sum) {
        return existsPairHelper(nums, sum, 0, nums.length-1);
    }

    private static boolean existsPairHelper(int[] nums, int sum, int lowerCounter, int upperCounter) {
        int tempSum = nums[lowerCounter] + nums[upperCounter];

        if (tempSum == sum)
            return true;
        if (lowerCounter == upperCounter)
            return false;
        if (sum > tempSum)
            return existsPairHelper(nums, sum, ++lowerCounter, upperCounter);
        return existsPairHelper(nums, sum, lowerCounter, --upperCounter);
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

    private static int[] reverseArrayRec(int[] nums) {
        return helperReverseArray(nums, 0, nums.length-1);
    }

    private static int[] helperReverseArray(int[] nums, int i, int j) {
        if (i >= j)
            return nums;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return helperReverseArray(nums, ++i, --j);
    }

}
