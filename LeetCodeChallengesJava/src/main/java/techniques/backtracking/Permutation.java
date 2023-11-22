package techniques.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * <p>
 * https://leetcode.com/problems/permutations/solutions/685868/dfs-backtracking-python-java-javascript-picture/
 * https://algo.monster/problems/backtracking
 */
public class Permutation {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{0, 1};
        int[] nums3 = new int[]{0};

        System.out.println(permute(nums1)); //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permute(nums2)); // [[0,1],[1,0]]
        System.out.println(permute(nums3)); // [[1]]
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, result, new ArrayList<>());
        return result;
    }

    private static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> permutation) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!permutation.contains(nums[i])) {
                    permutation.add(nums[i]);
                    permuteHelper(nums, result, permutation);
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}
