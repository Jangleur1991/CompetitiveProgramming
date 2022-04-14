/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 *
 *
 */
public class MaximumSubarray {

    //O(n)
    //TODO: Try coding another solution using the divide and conquer approach, which is more subtle.
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int tempSum = nums[0];
        if (nums.length == 1)
            return sum;
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(nums[i], tempSum+nums[i]);
            sum = Math.max(sum, tempSum);
        }
        return sum;
    }
}
