package techniques.twoPointer;

import java.util.Arrays;

public class SumOfThreeValues {

    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 2, 8, 4, 5};
        System.out.println(findSumOfThree(nums, 10));
    }

    //Idea: a+b+c == target => b+c = target - a. So we can reuse the idea of
    // the two number sum problem!
    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if ( twoNumberSum(nums, i, target) )
                return true;
        }
        return false;
    }

    private static boolean twoNumberSum(int[] nums, int i, int target) {
        int left = i+1;
        int right = nums.length-1;

        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];

            if (currentSum == target) {
                return true;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
