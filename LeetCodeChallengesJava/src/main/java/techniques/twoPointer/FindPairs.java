package techniques.twoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        int[] nums1 = new int[]{3,1,4,1,5};
        int[] nums2 = new int[]{1,2,3,4,5};
        int[] nums3 = new int[]{1,3,1,5,4};
        int[] nums4 = new int[]{2,8,6,9,7,4,9,0,5,4};
        int[] nums5 = new int[]{1,3,1,5,4};

//        System.out.println(findPairs(nums1, 2));
//        System.out.println(findPairs(nums2, 1));
//        System.out.println(findPairs(nums3, 0));
        System.out.println(findPairs(nums4, 1)); //5
        System.out.println(findPairs(nums5,0 )); //1
    }

    private static int findPairs(int[] nums, int k) {
        int n = nums.length;
        if (n < 1) return 0;
        Arrays.sort(nums);
        int p1 = 0, p2 = 1;
        int result = 0;

        while (p2 < n && p1 < p2) {
               int diff = nums[p2] - nums[p1];
            if (p2 == n-1 || nums[p2] != nums[p2+1]) {
               if (diff == k) {
                   result++;
                   p2++;
                   p1++;
               } else if (diff < k) {
                   p2++;
               } else {
                   p1++;
               }
            } else {
                p2++;
            }
            if (p1 >= p2)
                p2++;
        }
        return result;
    }
}
