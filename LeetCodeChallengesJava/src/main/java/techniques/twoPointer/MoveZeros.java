package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * https://leetcode.com/problems/move-zeroes/editorial/
 */
public class MoveZeros
{
    public static void main( String[] args )
    {
        int[] nums1 = new int[]{0,1,0,3,12};
        int[] nums2 = new int[]{0};

        moveZeroes( nums1 );
        moveZeroes( nums2 );

        System.out.println( Arrays.toString( nums1 ) ); // 1,3,12,0,0
        System.out.println( Arrays.toString( nums2 ) ); // 0
    }
    //
    // private static void moveZeroes(int[] nums) {
    //     int n = nums.length;
    //     int[] result = new int[n];
    //
    //     // Count the zeroes
    //     int numZeros = 0;
    //     for ( int i = 0; i < n; i++ )
    //     {
    //         if (nums[i] == 0) numZeros++;
    //     }
    //
    //     // Make all the non-zero elements retain their original order.
    //     int resultIndex = 0;
    //     for ( int i = 0; i < n; i++ )
    //     {
    //         if (nums[i] != 0) {
    //             result[resultIndex++] = nums[i];
    //         }
    //     }
    //
    //     // Move all zeroes to the end
    //     while ( numZeros > 0 ) {
    //         numZeros--;
    //         result[resultIndex++] = 0;
    //     }
    //
    //     // Combine the result
    //     for ( int i = 0; i < n; i++ )
    //     {
    //        nums[i] = result[i];
    //     }
    // }

    // private static void moveZeroes(int[] nums) {
    //     int lastNonZeroIndex = 0;
    //     for ( int i = 0; i < nums.length; i++ )
    //     {
    //         if (nums[i] != 0)
    //             nums[lastNonZeroIndex++] = nums[i];
    //     }
    //
    //     for ( int i = lastNonZeroIndex; i < nums.length; i++ )
    //     {
    //         nums[i] = 0;
    //     }
    // }


    private static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
            if (nums[i] != 0) {
                swap( nums, i, lastNonZeroIndex );
                lastNonZeroIndex++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
