package techniques.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
 * such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * You may return the answer in any order.
 *
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,-1,0,-2,2};
        int target1 = 0;

        int[] nums2 = new int[]{2,2,2,2,2};
        int target2 = 8;

        int[] nums3 = new int[]{-2,-1,-1,1,1,2,2};
        int target3 = 0;

        int[] nums4 = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        int target4 = -294967296;

        int[] nums5 = new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        int target5 = 294967296;

        System.out.println(fourSum(nums1, target1));
        System.out.println(fourSum(nums2, target2));
        System.out.println(fourSum(nums3, target3));
        System.out.println(fourSum(nums4, target4));
        System.out.println(fourSum(nums5, target5));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return fourSumHelper(nums, target, 0, 4);
    }

    private static List<List<Integer>> fourSumHelper(int[] nums, long target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (start == nums.length)
            return result;

        if (nums[start] > target/k)
            return result;

        if (nums[nums.length-1] < target/k)
            return result;

        if (k == 2)
            return twoSum(nums, target, start);

        for (int i = start; i < nums.length - (k - 1); i++) {
            if ( i == start || nums[i-1] != nums[i]) {
                for (List<Integer> subresult: fourSumHelper(nums, target - nums[i], i + 1, k - 1)) {
                    List<Integer> collectSubResult = new ArrayList<>();
                    collectSubResult.add(nums[i]);
                    collectSubResult.addAll(subresult);
                    result.add(collectSubResult);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int lower = start;
        int higher = nums.length-1;

        while (lower < higher) {
            int sum = nums[lower] + nums[higher];
            if (sum < target || (lower > start && nums[lower] == nums[lower-1])) {
                lower++;
            } else if (sum > target || (higher < nums.length-1 && nums[higher] == nums[higher+1])) {
                higher--;
            } else {
                result.add(List.of(nums[lower], nums[higher]));
                lower++;
                higher--;
            }
        }
        return result;
    }

}
