package LeetCode1to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class TwoSums {
    public static void main(String[] args) {
        System.out.println(twoSumsWithNoDuplicates(new int[]{-1, -1, -1, 0, 1, 2, 2, 3}, 1));
    }

    private static List<List<Integer>> twoSumsWithNoDuplicates(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum == target) {
                result.add(List.of(nums[left], nums[right]));
                int currentLeft = nums[left];
                int currentRight = nums[right];
                while (nums[left] == currentLeft && left<right) left++;
                while (nums[right] == currentRight && left<right) right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
