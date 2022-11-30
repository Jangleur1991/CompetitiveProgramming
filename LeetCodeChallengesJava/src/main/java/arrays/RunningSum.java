package arrays;

import java.util.Arrays;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(Arrays.toString(runningSumRec(nums)));
    }

    private static int[] runningSumRec(int[] nums) {
        return sum(nums, 1);
    }

    private static int[] sum(int[] nums, int counter) {
        return (counter == nums.length)
                ? nums
                : sum(calcValue(nums, counter), ++counter);
    }

    private static int[] calcValue(int[] nums, int counter) {
        nums[counter] += nums[counter-1];
        return nums;
    }

    private static int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
