package techniques.backtracking;

/**
 * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
 *
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
 * Given an array nums, return the sum of all XOR totals for every subset of nums.
 *
 * Note: Subsets with the same elements should be counted multiple times.
 *
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
 *
 */

public class SubsetXORSum
{
    public static void main( String[] args )
    {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{5,1,6};
        int[] nums3 = new int[]{3,4,5,6,7,8};

        System.out.println(subsetXORSum(nums1)); //6
        System.out.println(subsetXORSum(nums2)); //28
        System.out.println(subsetXORSum(nums3)); //480
    }

    private static int subsetXORSum(int[] nums)
    {
        return subsetXORSumHelper( nums, 0, 0 );
    }

    private static int subsetXORSumHelper( int[] nums, int index, int currentXor )
    {
        if ( index == nums.length ) return currentXor;

        int withCurrentElement = subsetXORSumHelper( nums, index+1, currentXor^nums[index] );
        int withoutCurrentElement = subsetXORSumHelper( nums, index+1, currentXor );

        return withCurrentElement+withoutCurrentElement;
    }
}
