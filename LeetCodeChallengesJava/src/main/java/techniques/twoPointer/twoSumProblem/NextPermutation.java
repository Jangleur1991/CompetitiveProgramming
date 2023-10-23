package techniques.twoPointer.twoSumProblem;

import java.util.Arrays;

/**
 *
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
 * More formally, if all the permutations of the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that follows it in the sorted container.
 * If such arrangement is not possible, the array must be rearranged as the lowest possible order
 * (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory
 *
 * https://leetcode.com/problems/next-permutation/editorial/
 *
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{3,2,1};
        int[] nums3 = new int[]{1,1,5};

        nextPermutation(nums1);
        nextPermutation(nums2);
        nextPermutation(nums3);

        System.out.println(Arrays.toString(nums1)); //1,3,2
        System.out.println(Arrays.toString(nums2)); //1,2,3
        System.out.println(Arrays.toString(nums3)); //1,5,1

    }

    /**
     * 1 5 8 4 7 6 5 3 1
     *
     * a[i] = 7 > a[i-1] = 4
     * 7 6 5 3 1 is in descending order => when rearranging the elements a[j] for j>=i
     * we won't get a larger permutation.
     *
     * But we will for j>=i-1! So we must include the element a[i-1]!
     * Now, what kind of rearrangement will produce the next larger number? We want to create the permutation just
     * larger than the current one. Therefore, we need to replace the number a[i−1] with the number which
     * is just larger than itself among the numbers lying to its right section, say a[j].
     *
     * a[i-1] = 4, a[j] = 5 swap
     *
     * 1 5 8 5 7 6 4 3 1 //not the permutation we would though! We want the smallest => elements right
     * of a[i-1] must be in ascending order!
     *
     * Since all elements to the right of a[i] are already in descending order
     * => reverse them!
     *
     *
     *  1 2 3
     *  1 3 2
     *  2 1 3
     *  2 3 1
     *  3 1 2
     *  3 2 1
     * @param nums
     */
    private static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;
        if (i >= 0) {
            int j = nums.length-1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
