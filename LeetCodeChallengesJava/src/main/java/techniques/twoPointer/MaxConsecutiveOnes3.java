package techniques.twoPointer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive
 * 1's in the array if you can flip at most k 0's
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/solutions/1117602/interview-answer-java/
 *
 * Idea is always two pointer in question like that where you need to find longest subarray with some
 * modification power to you in array.
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;

        int[] nums2 = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;

        System.out.println(longestOnes(nums1, k1)); //6
        System.out.println(longestOnes(nums2, k2)); //10
    }

    private static int longestOnes(int[] nums, int k) {
        if (nums.length == 0)
            return 0;

        int left = 0, right = 0, result=0;
        Queue<Integer> zeroIndices = new ArrayDeque<>();

        while (right < nums.length) {
            if (nums[right] == 0)
                zeroIndices.add(right);

            if (zeroIndices.size()==k+1)
                left = zeroIndices.remove()+1;

            result = Math.max(result, right-left+1);
            right++;
        }
        return result   ;
    }
}
