package techniques.twoPointer.reverseswapping;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the
 * elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
 * following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,2,3};
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};

        int val1 = 3;
        int val2 = 2;

        System.out.println(removeElement(nums1, val1)); //2, nums = [2,2,_,_]
        System.out.println(removeElement(nums2, val2)); // 5, nums = [0,1,4,0,3,_,_,_]
    }

    private static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[j++] = nums[i];
        }
        return j;
    }
}
