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
        System.out.println(subsets(nums));
        System.out.println(subsets( nums1 )); //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets( nums2 )); //[[],[0]]

        bitmasksLengthN(3);
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

    //Two ways to generat bitmasks of a specific length
    private static void bitmasksLengthN(int n)
    {
        //
        int nthBit = 1 << n; // == 2^n
        for ( int i = 0; i < nthBit; i++ )
        {
            //i | nthBit sets the nthBit in front of the binary
            // which can be 0 or 1 but it guarantees the length of n+1 of the bitmask!
            //We then remove the first bit so we get only bitmasks of length n!
            String bitMask = Integer.toBinaryString( i | nthBit ).substring( 1 );
            System.out.println(bitMask);
        }

        System.out.println(" ");
        //Similar idea but we generate the bitmasks between 2^n and 2^n+1 - 1.
        // These bitmask are guaranteed to have a length of n+1
        // Again we remove the first bit => we get all bitmasks of length n!
        for ( int i = (int) Math.pow( 2,  n); i < (int) Math.pow( 2,  n+1); i++ )
        {
            String bitMask = Integer.toBinaryString( i ).substring( 1 );
            System.out.println(bitMask);
        }
    }

    /**
     * Generate all possible binary bitmasks of length n.
     *
     * Map a subset to each bitmask:
     * 1 on the ith position in bitmask means the presence of nums[i]
     * in the subset, and 0 means its absence.
     *
     * Return output list.
     * @param nums
     * @return
     */
    private static List<List<Integer>> subsetsUsingBitmasks(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int nthBit = 1 << (nums.length);

        // generate bitmask, from 0..00 to 1..11
        for ( int i = 0; i < nthBit; i++ )
        {
            // generate bitmask, from 0..00 to 1..11
            String bitMask = Integer.toBinaryString( i | nthBit ).substring( 1 );

            //
            List<Integer> subset = new ArrayList<>();
            for ( int j = 0; j < nums.length; j++ )
            {
                if ( bitMask.charAt( j ) == '1' ) subset.add( nums[j] );
            }
            result.add( subset );
        }
        return result;
    }
}
