package techniques.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetWithDup
{
    public static void main( String[] args )
    {
        int[] nums1 = new int[]{1,2,2};
        int[] nums2 = new int[]{0};

        System.out.println(subsetsWithDup(nums1)); //[[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(subsetsWithDup(nums2)); //[[],[0]]
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort( nums );
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(nums, currentSubset, 0, result);
        return result;
    }

    private static void generateSubsets( int[] nums, List<Integer> subset, int index, List<List<Integer>> result )
    {
        if (index == nums.length) {
            result.add( new ArrayList<>(subset) );
        } else {
            subset.add( nums[index] );
            generateSubsets( nums, subset, index+1, result );
            subset.remove( subset.size()-1 );
            while (index+1 < nums.length && nums[index] == nums[index+1]) index++;
            generateSubsets( nums, subset, index+1, result );
        }
    }

}
