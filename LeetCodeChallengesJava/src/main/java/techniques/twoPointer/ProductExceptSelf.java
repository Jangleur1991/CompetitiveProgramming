package techniques.twoPointer;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/
 */
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(productExceptSelf(nums1))); //24,12,8,6
        System.out.println(Arrays.toString(productExceptSelf(nums2))); //0,0,9,0,0
    }

//    private static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int product;
//        int[] result = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            product = 1;
//            for (int j = 0; j < n; j++) {
//                if (i != j)
//                    product *= nums[j];
//            }
//            result[i] = product;
//        }
//        return result;
//    }

    //You can't do simply do it with a product and then divide
//    private static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] suffix = new int[n];
//        int[] prefix = new int[n];
//        int[] result = new int[n];
//
//        prefix[0] = 1;
//        suffix[n-1] = 1;
//
//        for (int i = 1; i < n; i++) {
//            prefix[i] = prefix[i-1]*nums[i-1];
//        }
//
//        for (int i = n-2; i >=0; i--) {
//            suffix[i] = suffix[i+1]*nums[i+1];
//        }
//
//        for (int i = 0; i < n; i++) {
//            result[i] = suffix[i]*prefix[i];
//        }
//
//        return result;
//    }

    private static int[] productExceptSelf(int[] nums) {
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
