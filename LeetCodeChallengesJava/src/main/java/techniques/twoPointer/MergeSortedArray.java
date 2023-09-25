package techniques.twoPointer;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 * https://leetcode.com/problems/merge-sorted-array/solutions/2651949/java-very-simple-solution-with-explanation/
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1)); //1,2,2,3,5,6

        int[] nums11 = new int[]{1};
        int m1 = 1;
        int[] nums21 = new int[]{};
        int n1 = 0;

        merge(nums11,m1,nums21,n1);
        System.out.println(Arrays.toString(nums11)); //1

        int[] nums12 = new int[]{0};
        int m2 = 1;
        int[] nums22 = new int[]{1};
        int n2 = 1;

        merge(nums12,m2,nums22,n2);
        System.out.println(Arrays.toString(nums12)); //1

    }

//    private static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int i = m-1, j = n-1, k = nums1.length-1;
//        while(j>=0) {
//            if (i >= 0 && nums1[i] > nums2[j]) {
//                nums1[k] = nums1[i];
//                k--;
//                i--;
//            } else {
//                nums1[k] = nums2[j];
//                j--;
//                k--;
//            }
//        }
//    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeHelper(nums1, m-1, nums2, n-1, nums1.length-1);
    }

    private static void mergeHelper(int[] nums1, int i, int[] nums2, int j, int k) {
        if (j>=0) {
            if (i>=0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                mergeHelper(nums1, i-1, nums2, j, k-1);
            } else {
                nums1[k] = nums2[j];
                mergeHelper(nums1, i, nums2, j-1, k-1);
            }
        }
    }

}
