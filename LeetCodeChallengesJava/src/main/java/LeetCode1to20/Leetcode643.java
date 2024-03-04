package LeetCode1to20;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-average-subarray-i/description/
//https://levelup.gitconnected.com/grokking-the-coding-interview-pattern-sliding-window-20ef83ae5872
public class Leetcode643 {
    public static void main(String[] args) {
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int[] nums2 = {5};
        int[] nums3 = {-1};
        int[] nums4 = {4,0,4,3,3};

        System.out.println(findMaxAverage(nums1, 4)); //12.75000
        System.out.println(findMaxAverage(nums2, 1)); //5.000
        System.out.println(findMaxAverage(nums3, 1)); //-1.000
        System.out.println(findMaxAverage(nums4, 5)); //2.80000
    }

//    private static double findMaxAverage(int[] nums, int k) {
//        double result = -Double.MAX_VALUE;
//        int windowStart = 0, windowEnd = 0;
//        double windowSum = 0.0;
//        while (windowEnd < nums.length) {
//            windowSum += nums[windowEnd];
//            if (windowEnd >= k-1) {
//                result = Math.max(windowSum / k, result);
//                windowSum -= nums[windowStart];
//                windowStart++;
//            }
//            windowEnd++;
//        }
//        return result;
//    }

    private static double findMaxAverage(int[] nums, int k) {
        double result = 0.0, windowSum = 0.0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
            windowSum = result;
        }

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            result = Math.max(windowSum, result);
        }
        return result/k;
    }
}
