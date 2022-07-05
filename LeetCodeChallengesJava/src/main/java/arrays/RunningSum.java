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
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    private static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += nums[i];
            ans[i] = temp;
        }
        return ans;
    }
}
