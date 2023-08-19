package techniques.twoPointer;

/**
 * Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
 *
 * Return the shortest such subarray and output its length.
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/editorial/
 */
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = new int[]{1, 2, 3, 4};
        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{1,3,2};
//
        System.out.println(findUnsortedSubarray(nums1));
        System.out.println(findUnsortedSubarray(nums2));
        System.out.println(findUnsortedSubarray(nums3));
        System.out.println(findUnsortedSubarray(nums4));
    }

    // Brute Force
    // Consider all subarrays
    // Try to check the following conditions for each subarray [i, j-1]
    // 1) Are all elements of the subarrays [0, i-1], [j, nums.length] sorted?
    // 2) Are all elements of [0, i-1],[j, nums.length] smaller/bigger than [i, j-1]?
    // Idea: 1. Calculate the min/max of [i, j-1]
    // Idea: 2. Take advantage of the fact that if the arrays are sorted,
    // then only in order to check 2. the elements nums[i - 1] and nums[j]
    // must be compared with the minimum/maximum.
    // If that already goes wrong, then you don't even have to check the sorting of the two arrays
    // [0, i-1],[j, nums.length].
    private static int findUnsortedSubarray(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length+1; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;

                // Calc the min/max of [i, j-1] (Idea 1)
                for (int k = i; k < j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }

                //Check Idea 2: If the arrays [0,i-1] and [j, nums.length]
                // are sorted, then we need to check the if condition.
                // We check this first because it's less effort
                // than checking if the arrays are sorted!
                if ((i == 0 || min >= nums[i - 1]) && ( j == nums.length || nums[j] >= max)) {
                    //Check if [0,i-1] is sorted
                    int k = 0;
                    while (k < i && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }

                    //Check if [0,i-1] is sorted
                    if (k == i) {
                        //Check if [j, nums.length] is sorted
                        k = j;
                        while (k < nums.length && prev <= nums[k]) {
                            prev = nums[k];
                            k++;
                        }
                        //Check if [j, nums.length] is sorted
                        if (k == nums.length)
                            result = Math.min(result, j - i);
                    }

                }
            }
        }
        return result;
    }
}