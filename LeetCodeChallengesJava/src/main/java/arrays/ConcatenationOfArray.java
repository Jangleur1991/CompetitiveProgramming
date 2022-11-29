package arrays;

import java.util.Arrays;

/**
 * Given an integer array nums of length n, you want to create an array ans of length 2n where
 * ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
 *
 * Specifically, ans is the concatenation of two nums arrays.
 *
 * Return the array ans.
 */
public class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(getConcatenationRec(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        for (int i=0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }


    public static int[] getConcatenationRec(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        return concateHelper(nums, ans, n-1);
    }

    private static int[] concateHelper(int[] nums, int[] ans, int counter) {
        if (counter == -1)
            return ans;
        ans[counter] = nums[counter];
        ans[counter+nums.length] = nums[counter];
        return concateHelper(nums, ans, --counter);
    }

}
