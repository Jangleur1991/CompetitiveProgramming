package techniques.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static void main(String[] args) {
       int[] nums1 = {-1,0,1,2,-1,-4};
       int[] nums2 = {0,1,1};

        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            while (i > 0 && nums[i] == nums[i-1] && i < nums.length-2)
                i++;
            threeSumHelper(nums, i, result);
        }
        return result;
    }

    private static void threeSumHelper(int[] nums, int i, List<List<Integer>> result) {
        int left = i+1;
        int right = nums.length-1;
        int num = nums[i];

        while (left < right) {
            int currentSum = nums[left] + nums[right] + num;

            if (currentSum == 0) {
                result.add(List.of(nums[left], nums[right], num));
                int tempRight = right;
                int tempLeft = left;
                while (left < right && nums[right] == nums[tempRight]) right--;
                while (left < right && nums[left] == nums[tempLeft]) left++;
            } else if (currentSum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
