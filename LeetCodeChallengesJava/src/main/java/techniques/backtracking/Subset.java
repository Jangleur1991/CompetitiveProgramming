package techniques.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * https://leetcode.com/problems/subsets/editorial/
 */
public class Subset
{
    public static void main( String[] args )
    {
        int[] nums = new int[]{1,2};
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{0};

        subsets( nums );
        System.out.println(subsets( nums1 )); //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets( nums2 )); //[[],[0]]
    }

    // private static List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     result.add( new ArrayList<>() );
    //
    //     for ( int num : nums )
    //     {
    //         List<List<Integer>> newSubsets = new ArrayList<>();
    //         // Add each element to each created subset
    //         for ( List<Integer> subset : result )
    //         {
    //             List<Integer> newSubset = new ArrayList<>( subset );
    //             newSubset.add( num );
    //             newSubsets.add( newSubset );
    //         }
    //
    //         //Add new subsets to result
    //         result.addAll( newSubsets );
    //     }
    //     return result;
    // }

    private static List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, subset, 0, result);
        return result;
    }

    private static void generateSubsets( int[] nums, List<Integer> subset, int index, List<List<Integer>> result )
    {
        if (index == nums.length)
            result.add( new ArrayList<>( subset ) );
        else {
            subset.add( nums[index] );
            generateSubsets( nums, subset, index+1, result );

            subset.remove( subset.size() - 1 );
            generateSubsets( nums, subset, index+1, result );
        }
    }
}
