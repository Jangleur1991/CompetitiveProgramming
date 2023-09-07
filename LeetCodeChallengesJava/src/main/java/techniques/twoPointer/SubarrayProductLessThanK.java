package techniques.twoPointer;

/**
 *
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all
 * the elements in the subarray is strictly less than k.
 *
 * https://leetcode.com/problems/subarray-product-less-than-k/editorial/
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums1 = new int[]{10,5,2,6};
        int[] nums2 = new int[]{1,2,3};

        System.out.println(numSubarrayProductLessThanK(nums1, 100)); //8
        System.out.println(numSubarrayProductLessThanK(nums2, 0)); //0
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        int result = 0;
        double logk = Math.log(k);

        double[] sumOfLogs = new double[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sumOfLogs[i+1] = sumOfLogs[i] + Math.log(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = sumOfLogs.length;
            while (left < right) {
                int midIndex = (left+right)/2;
                if (sumOfLogs[midIndex] - sumOfLogs[i] < logk)
                    left = midIndex + 1;
                else
                    right = midIndex;
            }

            result += left-i-1;
        }
        return result;
    }

}
