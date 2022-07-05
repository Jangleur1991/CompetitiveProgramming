package arrays;

import java.util.Arrays;

/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same
 * length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 *
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 */
public class BuildArrayFromPermutation {

    public static void main(String[] args) {
         int[] nums = {2,0,1};

        System.out.println(Arrays.toString(buildArray(nums)));
    }

    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        //You must store two values in one variable to
        //reach the goal of O(1) (no additional space) space complexity
        //Idea: Store c = oldValue+newValue*n where n == nums.length
        //(c%n) == oldValue, (c/n) == newValue
        // nums[i] = nums[i] + n*(nums[nums[i]]%n)
        for (int i = 0; i < n; ++i)
            nums[i] += n * (nums[nums[i]] % n);

        for (int i = 0; i < n; ++i)
            nums[i] /= n;

        return nums;
    }
}