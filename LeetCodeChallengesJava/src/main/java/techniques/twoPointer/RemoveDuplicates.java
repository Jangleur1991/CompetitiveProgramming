package techniques.twoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * Idea:
     * - have a result variable that will be initialised as 1
     * - have two pointers both at the start of the array: left & right
     * - move the right pointer one step forward:
     * - if its value is not equal to left's value, increment the value of res_length & move the left pointer to right's position
     * - if equal, repeat this step (move the right pointer one step forward)
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        int lastNonDuplicateIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[lastNonDuplicateIndex]) {
                result++;
                lastNonDuplicateIndex = i;
            }
        }
        return result;
    }

    /**
     * In this problem, we need to remove the duplicates in-place such that the resultant length of the array remains sorted.
     * As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates.
     * In other words, we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number.
     * So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
     * @param nums
     * @return
     */
    private static int removeDuplicates2(int[] nums) {
        Arrays.sort(nums);
        int nextNonDuplicated = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[nextNonDuplicated-1] != nums[i]) {
                nums[nextNonDuplicated] = nums[i];
                nextNonDuplicated++;
            }
        }
        return nextNonDuplicated;
    }
}
