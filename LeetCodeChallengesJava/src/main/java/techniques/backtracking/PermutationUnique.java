package techniques.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * https://leetcode.com/problems/permutations-ii/editorial/
 * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
 *
 */
public class PermutationUnique {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{1,2,3};

        System.out.println(permuteUnique(nums1)); //[[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(permuteUnique(nums2)); //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Long> counter = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        List<Integer> currentPermutation = new ArrayList<>();
        permutateHelper(currentPermutation, nums.length, counter, result);
        return result;
    }

    private static void permutateHelper(List<Integer> currentPermutation, int length, Map<Integer, Long> counter, List<List<Integer>> result) {
        if (currentPermutation.size() == length) {
            //deep copy since the permutation would be backtracked later
            result.add(new ArrayList<>(currentPermutation));
        } else {
            for ( var entry : counter.entrySet() ) {
                Integer num = entry.getKey();
                Long count = entry.getValue();
                if (count != 0)
                {
                    //put num to current permutation
                    currentPermutation.add(num);
                    counter.put(num, count - 1); //update counter

                    permutateHelper(currentPermutation, length, counter, result);

                    //backtrack
                    currentPermutation.remove(currentPermutation.size()-1);
                    counter.put(num, count);
                }
            }
        }
    }
}
