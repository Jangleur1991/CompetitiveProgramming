package techniques.twoPointer;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 *
 */
public class FindPairs {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 1, 4, 1, 5};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        int[] nums3 = new int[]{1, 3, 1, 5, 4};
        int[] nums4 = new int[]{2, 8, 6, 9, 7, 4, 9, 0, 5, 4};
        int[] nums5 = new int[]{1, 3, 1, 5, 4};

        System.out.println(findPairs(nums1, 2));
        System.out.println(findPairs(nums2, 1));
        System.out.println(findPairs(nums3, 0));
        System.out.println(findPairs(nums4, 1)); //5
        System.out.println(findPairs(nums5, 0)); //1

    }

//    private static int findPairs(int[] nums, int k) {
//        int n = nums.length;
//        if (n < 1) return 0;
//        Arrays.sort(nums);
//        int p1 = 0, p2 = 1;
//        int result = 0;
//
//        while (p2 < n && p1 < p2) {
//            int diff = nums[p2] - nums[p1];
//            if (p2 == n - 1 || nums[p2] != nums[p2 + 1]) {
//                if (diff == k) {
//                    result++;
//                    p2++;
//                    p1++;
//                } else if (diff < k) {
//                    p2++;
//                } else {
//                    p1++;
//                }
//            } else {
//                p2++;
//            }
//            if (p1 >= p2)
//                p2++;
//        }
//        return result;
//    }

    private static int findPairsRec(int[] nums, int k) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        return findPairsHelper(nums, k, 0, 1, 0);
    }

    private static int findPairsHelper(int[] nums, int k, int p1, int p2, int result) {
        if (p2 >= nums.length) return result;
        int diff = nums[p2] - nums[p1];
        if ((p2 == nums.length - 1 || nums[p2] != nums[p2 + 1]) && p1 < p2) {
            if (diff < k)
                return findPairsHelper(nums, k, p1, p2 + 1, result);
            else if (diff > k)
                return findPairsHelper(nums, k, p1 + 1, p2, result);
            else
                return findPairsHelper(nums, k, p1 + 1, p2 + 1, result + 1);
        } else {
            return findPairsHelper(nums, k, p1, p2 + 1, result);
        }
    }

//    private static int findPairs(int[] nums, int k) {
//        if (nums.length < 2) return 0;
//        HashMap<Integer, Integer> helperMap = new HashMap<>();
//
//        int result = 0;
//        for (int num: nums) {
//            helperMap.put(num, helperMap.getOrDefault(num, 0) + 1);
//        }
//
//        var entries = helperMap.entrySet();
//
//        for (var entry: entries) {
//            if ((k == 0 && entry.getValue() >= 2) || (k > 0 && helperMap.containsKey(entry.getKey()+k)))
//                result++;
//        }
//        return result;
//    }

    private static int findPairs(int[] nums, int k) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        Set<Integer> pairs = new HashSet<>();

        for (int i = 0; i < n-1; i++) {
            if (binarySearchHelper(nums, nums[i]+k, i+1, n-1) > 0)
                pairs.add(nums[i]);
        }
        return pairs.size();
    }



    private static int binarySearch(int[] nums, int i) {
        return binarySearchHelper(nums, i, 0, nums.length-1);
    }

    private static int binarySearchHelper(int[] nums, int num, int left, int right) {
        if (left>right)
            return -1;

        int midIndex = (left+right)/2;
        int midElement = nums[midIndex];

        if (num == midElement)
            return midIndex;

        if (midElement < num)
            return binarySearchHelper(nums, num, midIndex+1, right);
        else
            return binarySearchHelper(nums, num, left, midIndex-1);
    }
}
