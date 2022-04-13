/**
 * Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to
 * the product of all the elements of nums except nums[i].
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Can you solve the problem in O(1) extra space complexity?
 *
 *
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] product = new int[length];
        int suffixProduct = 1;

        //1. Store prefixProduct in Product Array
        product[0] = 1;
        for (int i = 1; i < length; i++) {
            product[i] = nums[i-1]*product[i-1];
        }

        //2. Store suffixeProduct only of previous.
        for (int i = length-1; i >= 0; i--) {
            product[i] = product[i]*suffixProduct;
            suffixProduct *= nums[i];
        }

        return product;

    }
}
