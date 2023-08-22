package techniques.twoPointer;

import java.util.Arrays;
import java.util.Stack;

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
        int[] nums4 = new int[]{1, 3, 2};
        int[] nums5 = new int[]{1,3,2,2,2};
//
        System.out.println(findUnsortedSubarray(nums1));
        System.out.println(findUnsortedSubarray(nums2));
        System.out.println(findUnsortedSubarray(nums3));
        System.out.println(findUnsortedSubarray(nums4));
        System.out.println(findUnsortedSubarrayRec(nums5));
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
//    private static int findUnsortedSubarray(int[] nums) {
//        int result = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length+1; j++) {
//                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
//
//                // Calc the min/max of [i, j-1] (Idea 1)
//                for (int k = i; k < j; k++) {
//                    min = Math.min(min, nums[k]);
//                    max = Math.max(max, nums[k]);
//                }
//
//                //Check Idea 2: If the arrays [0,i-1] and [j, nums.length]
//                // are sorted, then we need to check the if condition.
//                // We check this first because it's less effort
//                // than checking if the arrays are sorted!
//                if ((i == 0 || min >= nums[i - 1]) && ( j == nums.length || nums[j] >= max)) {
//                    //Check if [0,i-1] is sorted
//                    int k = 0;
//                    while (k < i && prev <= nums[k]) {
//                        prev = nums[k];
//                        k++;
//                    }
//
//                    //Check if [0,i-1] is sorted
//                    if (k == i) {
//                        //Check if [j, nums.length] is sorted
//                        k = j;
//                        while (k < nums.length && prev <= nums[k]) {
//                            prev = nums[k];
//                            k++;
//                        }
//                        //Check if [j, nums.length] is sorted
//                        if (k == nums.length)
//                            result = Math.min(result, j - i);
//                    }
//
//                }
//            }
//        }
//        return result;
//    }

    //Better Brute Force
    // Idea: Find the smallest/greatest element that is not in the correct sorted position.
    // Similar approach to Selection Sort! For this, we compare nums[i] with every nums[j],
    // such that i<j<n. If any nums[j] happens to be lesser than nums[i],
    // it means both nums[i] and nums[j] aren't at their correct position for the sorted array.
//    private static int findUnsortedSubarray(int[] nums) {
//        int l = nums.length, r = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    l = Math.min(l, i);
//                    r = Math.max(r, j);
//                }
//            }
//        }
//        return r - l < 0 ? 0 : r - l + 1;
//    }

    // Using a sorted array
    // Find the smallest/greatest element that is not in the correct sorted position.
//    private static int findUnsortedSubarray(int[] nums) {
//        int[] clone = nums.clone();
//        Arrays.sort(clone);
//        int start = nums.length, end = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != clone[i]) {
//                start = Math.min(i, start);
//                end = Math.max(end, i);
//            }
//        }
//        return end - start < 0 ? 0 : end - start + 1;
//    }


    // Idea: https://www.youtube.com/watch?v=UfBfr-VRYOU&t=2s and https://twchen.gitbook.io/leetcode/array/shortest-unsorted-continuous-subarray
    // 1) Find subarray where unsorted starts and ends definitely [s,e]
    // 2) Determine min/max of the array
    // 3) min must be greater than all [0, s-1] and max must be smaller than all [e+1, n-1]
    // 4) Combine both steps:
    //  4.1) Find longest subarray nums[0,.., right] such that max(nums[0,.., right]) <= nums[right+1, .. n-1]
    //  4.2) Find longest subarray nums[left, ... n-1] such that min(nums[left, ... n-1]) >= nums[0,..,left-1]
    //  4.3) The shortest subarray we want to find is nums[left..right]
    //  Another way to think about it is to first calculate the right bound. What properties must be true for this one?
    //  It must satisfy two properties:
    //   1. The index "right" must be in a wrong position (in the sense of a sorted array) in nums
    //   i. e. that means there is at least one index "i" with i < right and nums[i] > nums[right].
    //   In order to check whether such an i exists, one can simply always compare the current element
    //   with the previously largest element found when running through a loop. If it is larger than max,
    //   you have found a new maximum. If it is smaller, then the current element is in the "wrong position".
    //   2. "right" must be the largest index in nums with the property 1.
    //  The same can be done for finding the left bound. However, you go through the whole process from the other side of the array.

    //    private static int findUnsortedSubarray(int[] nums) {
//        int n = nums.length;
//        if (n < 2) return 0;
//        int left = 1, right = 0;
//        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            if (max > nums[i]) {
//                right = i;
//            } else {
//                max = nums[i];
//            }
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            if (min < nums[i]) {
//                left = i;
//            } else {
//                min = nums[i];
//            }
//        }
//        return right - left + 1;
//    }
    private static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length, right = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                left = Math.min(left, stack.pop());
            stack.push(i);
        }
        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                right = Math.max(right, stack.pop());
            stack.push(i);
        }

        return right - left < 0 ? 0 : right - left + 1;
    }

    private static int findUnsortedSubarrayRec(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int right = 0, left = nums.length;
        return findUnsortedSubarrayHelper(nums, left, right, 0);
    }

    private static int findUnsortedSubarrayHelper(int[] nums, int left, int right, int index) {
        if (index == nums.length)
            return right - left < 0 ? 0 : right - left + 1;

        if (index < nums.length-1 && nums[index] < nums[index+1]) {
            left = Math.min(left, index+1);
            right = Math.max(right, index);
        }

        return findUnsortedSubarrayHelper(nums, left, right, index+1);
    }

}