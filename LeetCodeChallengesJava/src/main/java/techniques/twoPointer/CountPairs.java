package techniques.twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given a 0-indexed integer array nums of length n and an integer target,
 * return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target.
 *
 */
public class CountPairs {
    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>(List.of(-1, 1, 2, 3, 1));
        List<Integer> nums2 = new ArrayList<>(List.of(-6, 2, 5, -2, -7, -1, 3));

        // -1, 1, 1, 2, 3
        //
        int target1 = 2;
        int target2 = -2;

        System.out.println(countPairs(nums1, target1)); //3
        System.out.println(countPairs(nums2, target2)); //10
    }

//    private static int countPairs(List<Integer> nums, int target) {
//        Collections.sort(nums);
//        int result = 0;
//        int left = 0;
//        int right = nums.size() - 1;
//        while (left < right) {
//            int currentSum = nums.get(left) + nums.get(right);
//            if (currentSum < target) {
//                result += right - left;
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return result;
//    }

    private static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.size(); i++) {
            int left = 0;
            int right = i-1;
            int currentNumberOfPairs = i;

            while (left <= right) {
                int midElementIndex = (left+right)/2;
                if (nums.get(midElementIndex) >= target - nums.get(i)) {
                    currentNumberOfPairs = midElementIndex;
                    right = midElementIndex-1;
                } else {
                    left = midElementIndex+1;
                }
            }
            result +=currentNumberOfPairs;
        }
        return result;
    }
}
