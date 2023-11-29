package techniques.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
 * of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less
 * than 150 combinations for the given input.
 * <p>
 * https://leetcode.com/problems/combination-sum/solutions/1777569/full-explanation-with-state-space-tree-recursion-and-backtracking-well-explained-c/
 * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, 6, 7};
        int[] nums2 = new int[]{2, 3, 5};
        int[] nums3 = new int[]{2};

        System.out.println(combinationSum(nums1, 7)); //[[2,2,3],[7]]
        System.out.println(combinationSum(nums2, 8)); //[[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(combinationSum(nums3, 1)); //[]
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void combinationSumHelper(List<List<Integer>> result,
                                             List<Integer> currentCombination,
                                             int[] candidates,
                                             int remainingSum,
                                             int startIndex) {
        if (remainingSum == 0) {
            result.add(new ArrayList<>(currentCombination));
        }
        if (remainingSum > 0) {
            for (int i = startIndex; i < candidates.length; i++) { //try all possible options for the next level
                currentCombination.add(candidates[i]);
                combinationSumHelper(result, currentCombination, candidates, remainingSum - candidates[i], i); // not i + 1 because we can reuse same elements
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
