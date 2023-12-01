package techniques.backtracking;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * https://leetcode.com/problems/combination-sum-ii/editorial/
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{10,1,2,7,6,1,5};
        int[] nums2 = new int[]{2,5,2,1,2};

        System.out.println(combinationSum2(nums1, 8)); //[[1,1,6],[1,2,5],[1,7],[2,6]]
        System.out.println(combinationSum2(nums2, 5)); //[[1,2,2],[5]]
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentComb = new ArrayList<>();

        var counter = Arrays.stream(candidates)
                .boxed()
                .collect(Collectors.toMap(
                        Function.identity(),
                        num -> 1,
                        Integer::sum
                ));
        combinationSum2Helper(currentComb, target, 0, new ArrayList<>(counter.entrySet()), result);
        return null;
    }

    private static void combinationSum2Helper(List<Integer> currentComb,
                                              int remainingSum,
                                              int currentIndex,
                                              List<Map.Entry<Integer, Integer>> counter,
                                              List<List<Integer>> result) {
        if (remainingSum == 0)
        {
            result.add(new ArrayList<>(currentComb));
        } else {
            for (int i = currentIndex; i < counter.size(); i++) {


                Map.Entry<Integer, Integer> currentCandidate = counter.get(currentIndex);
                Integer candidateValue = currentCandidate.getKey();
                Integer candidateFreq = currentCandidate.getValue();

                if (candidateFreq > 0) {

                    currentComb.add(candidateValue);
                    currentCandidate.setValue(candidateFreq - 1);

                    combinationSum2Helper(currentComb, remainingSum - candidateValue, i, counter, result);

                    currentCandidate.setValue(candidateFreq);

                    currentComb.remove( currentComb.size()-1 );
                }
            }
        }
    }
}
