package techniques.twoPointer.twoSumProblem;

/**
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 */
public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,2,3,3,4,4,5,5};
        int[] nums2 = new int[]{1,1,2,2,2,2};
        int[] nums3 = new int[]{2,1,3};

        System.out.println(threeSumMulti(nums1, 8)); //20
        System.out.println(threeSumMulti(nums2, 5)); //12
        System.out.println(threeSumMulti(nums3, 6)); //1
    }

    private static int threeSumMulti(int[] arr, int target) {
        return 0;
    }
}
