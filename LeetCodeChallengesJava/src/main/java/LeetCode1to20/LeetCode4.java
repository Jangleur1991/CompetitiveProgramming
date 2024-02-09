package LeetCode1to20;


/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/editorial/
 */
public class LeetCode4 {

    private static int p1 = 0;
    private static int p2 = 0;
    public static void main(String[] args) {
        int[] nums11 = new int[]{1,3};
        int[] nums21 = new int[]{2};

        int[] nums12 = new int[]{1,2};
        int[] nums22 = new int[]{3,4};

        int[] nums13 = new int[]{};
        int[] nums23 = new int[]{1};

        System.out.println(findMedianSortedArrays(nums11, nums21));
        System.out.println(findMedianSortedArrays(nums12, nums22));
        System.out.println(findMedianSortedArrays(nums13, nums23));

    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n+m) % 2 == 0) {
            int temp1 = 0, temp2 = 0;
            for (int i = 0; i < (n+m)/2 + 1; i++) {
                temp2 = temp1;
                temp1 = calcMin(nums1, nums2);
            }
            return (double) (temp1+temp2)/2;
        } else {
            int temp = 0;
            for (int i = 0; i < (n + m) / 2 + 1; i++) {
                temp = calcMin(nums1, nums2);
            }
            return temp;
        }
    }



    private static int calcMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }
}
